package com.bytedance.awemeopen.apps.framework.comment.write.refactor.emoji;

import androidx.lifecycle.LifecycleOwner;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public interface g extends xy3.c {

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final a f194535m1 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f194536a = null;

        static {
            f194536a = new a();
        }

        public a() {
        }

        public static g a(wy3.a r100) {
            int r101 = xy3.a.f565402a;
            if (r100 == null) goto L7;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r102 = r100.f561864b;
            if (r102 == null) goto L7;
            LifecycleOwner r103 = r102.f195172d;
        L8:
            Intrinsics.checkNotNull(r103);
            return (g) xy3.a.a(g.class, r103);
        L7:
            r103 = null;
            goto L8
        }
    }

    static {
        f194535m1 = a.f194536a;
    }

    com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.a f();

    void m(boolean r100);

    void o();
}
