package com.ss.android.lark.todo.impl.features.detail.assignee.add.adapter;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class RecommendItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShowType f442573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f442574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f442575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f442576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Drawable f442577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f442578f;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/assignee/add/adapter/RecommendItem$ShowType;", "", "<init>", "(Ljava/lang/String;I)V", "TITLE", "CHATTER", "SELECTALL", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ShowType extends Enum<ShowType> {
        public static final ShowType CHATTER = null;
        public static final ShowType SELECTALL = null;
        public static final ShowType TITLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShowType[] f442579a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f442580b = null;

        public static EnumEntries<ShowType> getEntries() {
            return f442580b;
        }

        static {
            ShowType r100 = new ShowType("TITLE", 0);
            TITLE = r100;
            ShowType r101 = new ShowType("CHATTER", 1);
            CHATTER = r101;
            ShowType r102 = new ShowType("SELECTALL", 2);
            SELECTALL = r102;
            ShowType[] r103 = {r100, r101, r102};
            f442579a = r103;
            f442580b = EnumEntriesKt.enumEntries(r103);
        }

        public static ShowType[] values() {
            return (ShowType[]) f442579a.clone();
        }

        public static ShowType valueOf(String r100) {
            return (ShowType) r27.a.a(ShowType.class, r100);
        }

        public ShowType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chatter f442581a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f442582b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f442583c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f442581a, r101.f442581a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f442582b, r101.f442582b) == true) goto L15;
            return false;
        L15:
            if (this.f442583c == r101.f442583c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Chatter r100 = this.f442581a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = ((r101 * 31) + this.f442582b.hashCode()) * 31;
            if (this.f442583c == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ChatterItem(chatter=" + this.f442581a + ", department=" + this.f442582b + ", isInChat=" + this.f442583c + ')';
        }

        public a(Chatter r100, String r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = "";
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            Intrinsics.checkNotNullParameter(r101, "department");
            this.f442581a = r100;
            this.f442582b = r101;
            this.f442583c = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendItem) == true) goto L8;
        return false;
    L8:
        RecommendItem r101 = (RecommendItem) r100;
        if (this.f442573a == r101.f442573a) goto L12;
        return false;
    L12:
        if (this.f442574b == r101.f442574b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f442575c, r101.f442575c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f442576d, r101.f442576d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f442577e, r101.f442577e) == true) goto L24;
        return false;
    L24:
        if (this.f442578f == r101.f442578f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f442573a.hashCode() * 31;
        int r101 = 1231;
        if (this.f442574b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f442575c.hashCode()) * 31;
        a r104 = this.f442576d;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        Drawable r108 = this.f442577e;
        if (r108 == null) goto L14;
        r105 = r108.hashCode();
    L14:
        int r109 = (r107 + r105) * 31;
        if (this.f442578f == true) goto L19;
        r101 = 1237;
    L19:
        return r109 + r101;
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "RecommendItem(type=" + this.f442573a + ", isChecked=" + this.f442574b + ", titleStr=" + this.f442575c + ", chatterItem=" + this.f442576d + ", allDrawable=" + this.f442577e + ", isAllCanSelect=" + this.f442578f + ')';
    }

    public final ShowType getType() {
        return this.f442573a;
    }

    public RecommendItem(ShowType r100, String r101, a r102, Drawable r103, boolean r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r101 = "";
    L6:
        if ((r105 & 8) == 0) goto L9;
        r102 = null;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 32) == 0) goto L14;
        r104 = true;
    L14:
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "titleStr");
        this.f442573a = r100;
        this.f442574b = false;
        this.f442575c = r101;
        this.f442576d = r102;
        this.f442577e = r103;
        this.f442578f = r104;
    }
}
