package com.larus.bmhome.chat.markdown.imagetool;

import androidx.collection.LruCache;
import com.larus.bmhome.chat.ChatParam;
import com.ss.ttvideoengine.model.VideoRef;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f307107a = 0;

    static {
    }

    public g() {
    }

    public static final ChatParam a() {
        LruCache<String, wc9.e> r100 = ko8.a.f504531a;
        long r101 = ko8.a.f504535e;
        return new ChatParam(null, null, ko8.a.h(r101), "chat", ko8.a.e(r101), VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL);
    }
}
