package uhc;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes40.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f550117a = null;

    static {
        int[] r100 = new int[JsonToken.values().length];
        f550117a = r100;
        r100[JsonToken.BOOLEAN.ordinal()] = 1;
        r100[JsonToken.NULL.ordinal()] = 2;
        r100[JsonToken.NUMBER.ordinal()] = 3;
        r100[JsonToken.STRING.ordinal()] = 4;
    }
}
