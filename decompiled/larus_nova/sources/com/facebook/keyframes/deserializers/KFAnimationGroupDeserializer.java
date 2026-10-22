package com.facebook.keyframes.deserializers;

import android.util.JsonReader;
import com.facebook.keyframes.model.KFAnimationGroup;
import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
public class KFAnimationGroupDeserializer {
    static final AbstractListDeserializer<KFAnimationGroup> LIST_DESERIALIZER = null;

    public KFAnimationGroupDeserializer() {
    }

    static {
        LIST_DESERIALIZER = new AnonymousClass1();
    }

    public static KFAnimationGroup readObject(JsonReader r100) throws IOException {
        r100.beginObject();
        KFAnimationGroup.Builder r101 = new KFAnimationGroup.Builder();
    L4:
        if (r100.hasNext() == false) goto L25;
        String r102 = r100.nextName();
        r102.getClass();
        byte r103 = -1;
        switch(r102.hashCode()) {
            case 314070383: goto L17;
            case 506361563: goto L13;
            case 1394981546: goto L9;
            default: goto L20;
        };
    L20:
        switch(r103) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            default: goto L21;
        };
    L22:
        r101.parentGroup = r100.nextInt();
        goto L4
    L23:
        r101.groupId = r100.nextInt();
        goto L4
    L24:
        r101.animations = KFAnimationDeserializer.LIST_DESERIALIZER.readList(r100);
        goto L4
    L21:
        r100.skipValue();
        goto L4
    L9:
        if (r102.equals(KFAnimationGroup.PARENT_GROUP_JSON_FIELD) == false) goto L20;
        r103 = 2;
        goto L20
    L13:
        if (r102.equals("group_id") == false) goto L20;
        r103 = 1;
        goto L20
    L17:
        if (r102.equals("animations") == false) goto L20;
        r103 = 0;
        goto L20
    L25:
        r100.endObject();
        return r101.build();
    }
}
