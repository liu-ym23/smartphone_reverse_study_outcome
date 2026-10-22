package com.larus.audio.flow.client.cache;

import com.ss.texturerender.TextureRenderKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f289740a = 0;

    static {
    }

    public static String a(String r100, String r101, String r102, String r103) {
        StringBuilder r104 = new StringBuilder();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r104.append(r100);
        r104.append('-');
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104.append(r101);
        StringBuilder r105 = new StringBuilder(r104.toString());
        boolean r106 = false;
        if (r102 != null) goto L11;
    L21:
        if (r103 != null) goto L23;
    L24:
        r106 = true;
    L25:
        if (r106 == true) goto L28;
        r105.append("-" + r103.hashCode());
    L28:
        return r105.toString();
    L23:
        if (r103.length() != 0) goto L25;
    L11:
        if (r102.length() <= 0) goto L13;
        boolean r107 = true;
    L14:
        if (r107 == false) goto L21;
        JSONObject r108 = new JSONObject(r102);
        if (r108.has(TextureRenderKeys.KEY_IS_PITCH) == false) goto L19;
        r105.append("-" + r108.optInt(TextureRenderKeys.KEY_IS_PITCH));
    L19:
        if (r108.has("speech_rate") == false) goto L21;
        r105.append("-" + r108.optDouble("speech_rate"));
        goto L21
    L13:
        r107 = false;
        goto L14
    }
}
