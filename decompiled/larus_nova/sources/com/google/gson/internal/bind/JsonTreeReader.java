package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class JsonTreeReader extends JsonReader {
    private static final Object SENTINEL_CLOSED = null;
    private static final Reader UNREADABLE_READER = null;
    private int[] pathIndices;
    private String[] pathNames;
    private Object[] stack;
    private int stackSize;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.JsonTreeReader$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken = null;

        static {
            int[] r100 = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = r100;
            r100[JsonToken.NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    @Override // com.google.gson.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack = new Object[]{SENTINEL_CLOSED};
        this.stackSize = 1;
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPath() {
        return getPath(false);
    }

    @Override // com.google.gson.stream.JsonReader
    public String getPreviousPath() {
        return getPath(true);
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextName() throws IOException {
        return nextName(false);
    }

    static {
        UNREADABLE_READER = new AnonymousClass1();
        SENTINEL_CLOSED = new Object();
    }

    private String locationString() {
        return " at path " + getPath();
    }

    private Object peekStack() {
        return this.stack[this.stackSize - 1];
    }

    private Object popStack() {
        Object[] r100 = this.stack;
        int r101 = this.stackSize - 1;
        this.stackSize = r101;
        Object r102 = r100[r101];
        r100[r101] = null;
        return r102;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        push(((JsonArray) peekStack()).iterator());
        this.pathIndices[this.stackSize - 1] = 0;
    }

    @Override // com.google.gson.stream.JsonReader
    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        push(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.JsonReader
    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
        int r100 = this.stackSize;
        if (r100 <= 0) goto L6;
        int[] r101 = this.pathIndices;
        int r102 = r100 - 1;
        r101[r102] = r101[r102] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        this.pathNames[this.stackSize - 1] = null;
        popStack();
        popStack();
        int r100 = this.stackSize;
        if (r100 <= 0) goto L6;
        int[] r101 = this.pathIndices;
        int r102 = r100 - 1;
        r101[r102] = r101[r102] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        boolean r100 = ((JsonPrimitive) popStack()).getAsBoolean();
        int r101 = this.stackSize;
        if (r101 <= 0) goto L5;
        int[] r102 = this.pathIndices;
        int r103 = r101 - 1;
        r102[r103] = r102[r103] + 1;
    L5:
        return r100;
    }

    @Override // com.google.gson.stream.JsonReader
    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
        int r100 = this.stackSize;
        if (r100 <= 0) goto L6;
        int[] r101 = this.pathIndices;
        int r102 = r100 - 1;
        r101[r102] = r101[r102] + 1;
        return;
    }

    @Override // com.google.gson.stream.JsonReader
    public JsonToken peek() throws IOException {
        if (this.stackSize == 0) goto L5;
        Object r100 = peekStack();
        if ((r100 instanceof Iterator) == false) goto L20;
        boolean r101 = this.stack[this.stackSize - 2] instanceof JsonObject;
        Iterator r102 = (Iterator) r100;
        if (r102.hasNext() == false) goto L15;
        if (r101 == true) goto L12;
        push(r102.next());
        return peek();
    L12:
        return JsonToken.NAME;
    L15:
        if (r101 == false) goto L18;
        return JsonToken.END_OBJECT;
    L18:
        return JsonToken.END_ARRAY;
    L20:
        if ((r100 instanceof JsonObject) == false) goto L24;
        return JsonToken.BEGIN_OBJECT;
    L24:
        if ((r100 instanceof JsonArray) == false) goto L28;
        return JsonToken.BEGIN_ARRAY;
    L28:
        if ((r100 instanceof JsonPrimitive) == false) goto L44;
        JsonPrimitive r103 = (JsonPrimitive) r100;
        if (r103.isString() == false) goto L34;
        return JsonToken.STRING;
    L34:
        if (r103.isBoolean() == false) goto L38;
        return JsonToken.BOOLEAN;
    L38:
        if (r103.isNumber() == false) goto L42;
        return JsonToken.NUMBER;
    L42:
        throw new AssertionError();
    L44:
        if ((r100 instanceof JsonNull) == false) goto L48;
        return JsonToken.NULL;
    L48:
        if (r100 != SENTINEL_CLOSED) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new MalformedJsonException("Custom JsonElement subclass " + r100.getClass().getName() + " is not supported");
    L5:
        return JsonToken.END_DOCUMENT;
    }

    public void promoteNameToValue() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r100 = (Map.Entry) ((Iterator) peekStack()).next();
        push(r100.getValue());
        push(new JsonPrimitive((String) r100.getKey()));
    }

    @Override // com.google.gson.stream.JsonReader
    public String toString() {
        return "JsonTreeReader" + locationString();
    }

    @Override // com.google.gson.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken r100 = peek();
        if (r100 != JsonToken.END_OBJECT) goto L5;
    L9:
        return false;
    L5:
        if (r100 == JsonToken.END_ARRAY) goto L9;
        if (r100 == JsonToken.END_DOCUMENT) goto L9;
        return true;
    }

    @Override // com.google.gson.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken r100 = peek();
        JsonToken r101 = JsonToken.NUMBER;
        if (r100 != r101) goto L5;
    L9:
        double r102 = ((JsonPrimitive) peekStack()).getAsDouble();
        if (isLenient() == false) goto L12;
    L18:
        popStack();
        int r103 = this.stackSize;
        if (r103 <= 0) goto L21;
        int[] r104 = this.pathIndices;
        int r105 = r103 - 1;
        r104[r105] = r104[r105] + 1;
    L21:
        return r102;
    L12:
        if (Double.isNaN(r102) == true) goto L17;
        if (Double.isInfinite(r102) == false) goto L18;
    L17:
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + r102);
    L5:
        if (r100 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r101 + " but was " + r100 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken r100 = peek();
        JsonToken r101 = JsonToken.NUMBER;
        if (r100 != r101) goto L5;
    L9:
        int r102 = ((JsonPrimitive) peekStack()).getAsInt();
        popStack();
        int r103 = this.stackSize;
        if (r103 <= 0) goto L12;
        int[] r104 = this.pathIndices;
        int r105 = r103 - 1;
        r104[r105] = r104[r105] + 1;
    L12:
        return r102;
    L5:
        if (r100 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r101 + " but was " + r100 + locationString());
    }

    public JsonElement nextJsonElement() throws IOException {
        JsonToken r100 = peek();
        if (r100 == JsonToken.NAME) goto L13;
        if (r100 == JsonToken.END_ARRAY) goto L13;
        if (r100 == JsonToken.END_OBJECT) goto L13;
        if (r100 == JsonToken.END_DOCUMENT) goto L13;
        JsonElement r101 = (JsonElement) peekStack();
        skipValue();
        return r101;
    L13:
        throw new IllegalStateException("Unexpected " + r100 + " when reading a JsonElement.");
    }

    @Override // com.google.gson.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken r100 = peek();
        JsonToken r101 = JsonToken.NUMBER;
        if (r100 != r101) goto L5;
    L9:
        long r102 = ((JsonPrimitive) peekStack()).getAsLong();
        popStack();
        int r103 = this.stackSize;
        if (r103 <= 0) goto L12;
        int[] r104 = this.pathIndices;
        int r105 = r103 - 1;
        r104[r105] = r104[r105] + 1;
    L12:
        return r102;
    L5:
        if (r100 == JsonToken.STRING) goto L9;
        throw new IllegalStateException("Expected " + r101 + " but was " + r100 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken r100 = peek();
        JsonToken r101 = JsonToken.STRING;
        if (r100 != r101) goto L5;
    L9:
        String r102 = ((JsonPrimitive) popStack()).getAsString();
        int r103 = this.stackSize;
        if (r103 <= 0) goto L12;
        int[] r104 = this.pathIndices;
        int r105 = r103 - 1;
        r104[r105] = r104[r105] + 1;
    L12:
        return r102;
    L5:
        if (r100 == JsonToken.NUMBER) goto L9;
        throw new IllegalStateException("Expected " + r101 + " but was " + r100 + locationString());
    }

    @Override // com.google.gson.stream.JsonReader
    public void skipValue() throws IOException {
        JsonToken r100 = peek();
        int r101 = AnonymousClass2.$SwitchMap$com$google$gson$stream$JsonToken[r100.ordinal()];
        if (r101 != 1) goto L5;
        nextName(true);
        return;
    L5:
        if (r101 != 2) goto L7;
        endArray();
        return;
    L7:
        if (r101 != 3) goto L9;
        endObject();
        return;
    L9:
        if (r101 == 4) goto L17;
        popStack();
        int r102 = this.stackSize;
        if (r102 <= 0) goto L18;
        int[] r103 = this.pathIndices;
        int r104 = r102 - 1;
        r103[r104] = r103[r104] + 1;
        return;
    L18:
        return;
    }

    public JsonTreeReader(JsonElement r100) {
        super(UNREADABLE_READER);
        this.stack = new Object[32];
        this.stackSize = 0;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        push(r100);
    }

    private void expect(JsonToken r100) throws IOException {
        if (peek() != r100) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r100 + " but was " + peek() + locationString());
    }

    private String getPath(boolean r100) {
        StringBuilder r101 = new StringBuilder("$");
        int r102 = 0;
    L3:
        int r103 = this.stackSize;
        if (r102 >= r103) goto L31;
        Object[] r104 = this.stack;
        Object r105 = r104[r102];
        if ((r105 instanceof JsonArray) == false) goto L21;
        r102 = r102 + 1;
        if (r102 >= r103) goto L29;
        if ((r104[r102] instanceof Iterator) == false) goto L29;
        int r106 = this.pathIndices[r102];
        if (r100 == false) goto L19;
        if (r106 <= 0) goto L19;
        if (r102 != (r103 - 1)) goto L17;
    L18:
        r106 = r106 - 1;
        goto L19
    L17:
        if (r102 == (r103 - 2)) goto L18;
    L19:
        r101.append('[');
        r101.append(r106);
        r101.append(']');
    L29:
        r102 = r102 + 1;
        goto L3
    L21:
        if ((r105 instanceof JsonObject) == false) goto L29;
        r102 = r102 + 1;
        if (r102 >= r103) goto L29;
        if ((r104[r102] instanceof Iterator) == false) goto L29;
        r101.append('.');
        String r107 = this.pathNames[r102];
        if (r107 == null) goto L29;
        r101.append(r107);
        goto L29
    L31:
        return r101.toString();
    }

    private String nextName(boolean r100) throws IOException {
        expect(JsonToken.NAME);
        Map.Entry r101 = (Map.Entry) ((Iterator) peekStack()).next();
        String r102 = (String) r101.getKey();
        String[] r103 = this.pathNames;
        int r104 = this.stackSize - 1;
        if (r100 == false) goto L5;
        String r105 = "<skipped>";
    L6:
        r103[r104] = r105;
        push(r101.getValue());
        return r102;
    L5:
        r105 = r102;
        goto L6
    }

    private void push(Object r100) {
        int r101 = this.stackSize;
        Object[] r102 = this.stack;
        if (r101 != r102.length) goto L5;
        int r103 = r101 * 2;
        this.stack = Arrays.copyOf(r102, r103);
        this.pathIndices = Arrays.copyOf(this.pathIndices, r103);
        this.pathNames = (String[]) Arrays.copyOf(this.pathNames, r103);
    L5:
        Object[] r104 = this.stack;
        int r105 = this.stackSize;
        this.stackSize = r105 + 1;
        r104[r105] = r100;
    }
}
