package com.ss.android.lark.widget.photo.preview.intercept;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ActionMenuType f446724a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f446725b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PhotoItem f446726c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f446724a == r101.f446724a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f446725b, r101.f446725b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f446726c, r101.f446726c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f446724a.hashCode() * 31) + this.f446725b.hashCode()) * 31;
            PhotoItem r101 = this.f446726c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ActionMenuClick(type=" + this.f446724a + ", context=" + this.f446725b + ", photoItem=" + this.f446726c + ')';
        }

        @Override // com.ss.android.lark.widget.photo.preview.intercept.b
        public final PhotoItem a() {
            return this.f446726c;
        }

        @Override // com.ss.android.lark.widget.photo.preview.intercept.b
        public Context getContext() {
            return this.f446725b;
        }

        public final ActionMenuType getType() {
            return this.f446724a;
        }

        public a(ActionMenuType r100, Context r101, PhotoItem r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f446724a = r100;
            this.f446725b = r101;
            this.f446726c = r102;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photo.preview.intercept.b$b, reason: collision with other inner class name */
    public static final class C5411b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f446727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f446728b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PhotoItem f446729c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5411b) == true) goto L8;
            return false;
        L8:
            C5411b r101 = (C5411b) r100;
            if (Intrinsics.areEqual(this.f446727a, r101.f446727a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f446728b, r101.f446728b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f446729c, r101.f446729c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f446727a.hashCode() * 31) + this.f446728b.hashCode()) * 31;
            PhotoItem r101 = this.f446729c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "FuncActionClick(id=" + this.f446727a + ", context=" + this.f446728b + ", photoItem=" + this.f446729c + ')';
        }

        @Override // com.ss.android.lark.widget.photo.preview.intercept.b
        public final PhotoItem a() {
            return this.f446729c;
        }

        @Override // com.ss.android.lark.widget.photo.preview.intercept.b
        public Context getContext() {
            return this.f446728b;
        }

        public C5411b(String r100, Context r101, PhotoItem r102) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f446727a = r100;
            this.f446728b = r101;
            this.f446729c = r102;
        }
    }

    PhotoItem a();

    Context getContext();
}
