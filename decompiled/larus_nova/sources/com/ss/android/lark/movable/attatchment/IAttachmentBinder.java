package com.ss.android.lark.movable.attatchment;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes36.dex */
public interface IAttachmentBinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f432604a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f432605a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<Map<Integer, IAttachmentBinder>> f432606b = null;

        public Companion() {
        }

        static {
            f432605a = new Companion();
            f432606b = LazyKt.lazy(IAttachmentBinder$Companion$binders$2.INSTANCE);
        }
    }

    static {
        f432604a = Companion.f432605a;
    }

    void bind(d r100, b r101);

    int getAttachmentTypeId();
}
