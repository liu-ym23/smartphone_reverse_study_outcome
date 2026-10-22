package com.obric.assistant.settings.wakeupsound;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public interface h {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f392512a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f392512a, ((a) r100).f392512a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f392512a.hashCode();
        }

        public final String toString() {
            return "Option(item=" + this.f392512a + ')';
        }

        public a(g r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f392512a = r100;
        }
    }
}
