package com.obric.assistant.activation.presentation.runtime.manager;

import com.obric.assistant.activation.presentation.contract.ObricListeningVisualMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class ObricInteractorPresentationBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f385283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ObricInteractorPresentationBridge$binder$1 f385284b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f385285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f385286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ObricListeningVisualMode f385287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f385288d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f385285a == r101.f385285a) goto L12;
            return false;
        L12:
            if (this.f385286b == r101.f385286b) goto L15;
            return false;
        L15:
            if (this.f385287c == r101.f385287c) goto L18;
            return false;
        L18:
            if (this.f385288d == r101.f385288d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f385285a * 31) + this.f385286b) * 31) + this.f385287c.hashCode()) * 31;
            if (this.f385288d == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "LoggedState(renderer=" + this.f385285a + ", dataSource=" + this.f385286b + ", mode=" + this.f385287c + ", visible=" + this.f385288d + ')';
        }

        public a(int r100, int r101, ObricListeningVisualMode r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "mode");
            this.f385285a = r100;
            this.f385286b = r101;
            this.f385287c = r102;
            this.f385288d = r103;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.assistant.activation.presentation.runtime.manager.ObricInteractorPresentationBridge$binder$1] */
    static {
        f385284b = new ObricInteractorPresentationBridge$binder$1();
    }
}
