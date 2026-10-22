package okhttp3;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes42.dex */
public final class FormBody extends RequestBody {
    private static final MediaType CONTENT_TYPE = null;
    private final List<String> encodedNames;
    private final List<String> encodedValues;

    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        public Builder() {
            this(null);
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset r100) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = r100;
        }

        public Builder add(String r100, String r110) {
            if (r100 == null) goto L9;
            if (r110 == null) goto L7;
            this.names.add(HttpUrl.canonicalize(r100, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(r110, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }

        public Builder addEncoded(String r100, String r110) {
            if (r100 == null) goto L9;
            if (r110 == null) goto L7;
            this.names.add(HttpUrl.canonicalize(r100, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            this.values.add(HttpUrl.canonicalize(r110, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
            return this;
        L7:
            throw new NullPointerException("value == null");
        L9:
            throw new NullPointerException("name == null");
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    static {
        CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    }

    public int size() {
        return this.encodedNames.size();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public String encodedName(int r100) {
        return (String) ListProtector.get(this.encodedNames, r100);
    }

    public String encodedValue(int r100) {
        return (String) ListProtector.get(this.encodedValues, r100);
    }

    public String name(int r100) {
        return HttpUrl.percentDecode(encodedName(r100), true);
    }

    public String value(int r100) {
        return HttpUrl.percentDecode(encodedValue(r100), true);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink r100) throws IOException {
        writeOrCountBytes(r100, false);
    }

    public FormBody(List<String> r100, List<String> r101) {
        this.encodedNames = cvc.c.n(r100);
        this.encodedValues = cvc.c.n(r101);
    }

    private long writeOrCountBytes(@Nullable BufferedSink r100, boolean r101) {
        if (r101 == false) goto L4;
        Buffer r102 = new Buffer();
    L5:
        int r103 = this.encodedNames.size();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L10;
        if (r104 <= 0) goto L9;
        r102.writeByte(38);
    L9:
        r102.writeUtf8((String) ListProtector.get(this.encodedNames, r104));
        r102.writeByte(61);
        r102.writeUtf8((String) ListProtector.get(this.encodedValues, r104));
        r104 = r104 + 1;
        goto L6
    L10:
        if (r101 == false) goto L12;
        long r105 = r102.size();
        r102.clear();
        return r105;
    L12:
        return 0;
    L4:
        r102 = r100.buffer();
        goto L5
    }
}
