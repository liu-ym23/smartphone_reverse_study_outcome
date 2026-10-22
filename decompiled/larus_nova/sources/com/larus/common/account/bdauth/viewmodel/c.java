package com.larus.common.account.bdauth.viewmodel;

import com.baidu.platform.comapi.map.MapController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.viewmodel.a f325989a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325989a, ((a) r100).f325989a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325989a.hashCode();
        }

        public final String toString() {
            return "Account(item=" + this.f325989a + ')';
        }

        public a(com.larus.common.account.bdauth.viewmodel.a r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f325989a = r100;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f325990a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f325990a == ((b) r100).f325990a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f325990a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "AddAccount(enabled=" + this.f325990a + ')';
        }

        public b(int r100) {
            this.f325990a = true;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.c$c, reason: collision with other inner class name */
    public static final class C4179c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.viewmodel.a f325991a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4179c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325991a, ((C4179c) r100).f325991a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325991a.hashCode();
        }

        public final String toString() {
            return "SingleAccount(item=" + this.f325991a + ')';
        }

        public C4179c(com.larus.common.account.bdauth.viewmodel.a r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            this.f325991a = r100;
        }
    }

    public c() {
    }
}
