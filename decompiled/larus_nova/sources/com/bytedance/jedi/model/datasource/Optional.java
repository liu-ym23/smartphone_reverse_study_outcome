package com.bytedance.jedi.model.datasource;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/datasource/Optional;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "model_release"}, k = 1, mv = {1, 7, 1})
public final class Optional<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f251065b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Optional f251066c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f251067a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/datasource/Optional$Companion;", "", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        f251065b = new Companion(0);
        f251066c = new Optional(new Object());
    }

    public final T a() {
        if (Intrinsics.areEqual(this, f251066c) == false) goto L6;
        return null;
    L6:
        return (T) this.f251067a;
    }

    public Optional(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "element");
        this.f251067a = r100;
    }
}
