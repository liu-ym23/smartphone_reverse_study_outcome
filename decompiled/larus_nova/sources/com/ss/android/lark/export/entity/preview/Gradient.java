package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "content", "Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "<init>", "(Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;Lcom/ss/android/lark/export/entity/preview/Gradient$Content;)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "setType", "(Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;)V", "getContent", "()Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "setContent", "(Lcom/ss/android/lark/export/entity/preview/Gradient$Content;)V", "clone", "equals", "", "other", "", "hashCode", "", "component1", "component2", "copy", "toString", "", "GradientType", "Linear", "Content", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Gradient implements Serializable {
    private Content content;
    private GradientType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "Ljava/io/Serializable;", "<init>", "()V", "clone", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Content implements Serializable {
        public Content() {
        }

        public Content clone() {
            return new Content();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$GradientType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "LINEAR", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GradientType extends Enum<GradientType> implements Serializable {
        public static final a Companion = null;
        public static final GradientType LINEAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GradientType[] f420664a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420665b = null;
        private int value;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<GradientType> getEntries() {
            return f420665b;
        }

        static {
            GradientType r100 = new GradientType();
            LINEAR = r100;
            GradientType[] r101 = {r100};
            f420664a = r101;
            f420665b = EnumEntriesKt.enumEntries(r101);
            Companion = new a();
        }

        public GradientType() {
            super("LINEAR", 0);
            this.value = 0;
        }

        public static GradientType[] values() {
            return (GradientType[]) f420664a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static GradientType valueOf(String r100) {
            return (GradientType) r27.a.a(GradientType.class, r100);
        }

        public final void setValue(int r100) {
            this.value = r100;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0014\u001a\u00020\u0000H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\fJ\u001d\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J8\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Gradient$Linear;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/export/entity/preview/Gradient$Content;", "deg", "", "themeColors", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/Integer;Ljava/util/ArrayList;)V", "getDeg", "()Ljava/lang/Integer;", "setDeg", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getThemeColors", "()Ljava/util/ArrayList;", "setThemeColors", "(Ljava/util/ArrayList;)V", "clone", "equals", "", "other", "", "hashCode", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/ArrayList;)Lcom/ss/android/lark/export/entity/preview/Gradient$Linear;", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Linear extends Content {
        private Integer deg;
        private ArrayList<ThemeColor> themeColors;

        /* JADX WARN: Multi-variable type inference failed */
        public Linear() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Linear copy$default(Linear r100, Integer r101, ArrayList r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.deg;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.themeColors;
        L9:
            return r100.copy(r101, r102);
        }

        public final Integer component1() {
            return this.deg;
        }

        public final ArrayList<ThemeColor> component2() {
            return this.themeColors;
        }

        public final Linear copy(Integer r100, ArrayList<ThemeColor> r101) {
            return new Linear(r100, r101);
        }

        public String toString() {
            return "Linear(deg=" + this.deg + ", themeColors=" + this.themeColors + ')';
        }

        @Override // com.ss.android.lark.export.entity.preview.Gradient.Content
        public Linear clone() {
            ArrayList r100 = new ArrayList();
            ArrayList<ThemeColor> r101 = this.themeColors;
            if (r101 == null) goto L9;
            Iterator<T> r102 = r101.iterator();
        L6:
            if (r102.hasNext() == false) goto L9;
            r100.add(((ThemeColor) r102.next()).clone());
        L9:
            return new Linear(this.deg, r100);
        }

        public int hashCode() {
            Integer r100 = this.deg;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.intValue();
        L6:
            int r103 = r102 * 31;
            ArrayList<ThemeColor> r104 = this.themeColors;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final Integer getDeg() {
            return this.deg;
        }

        public final ArrayList<ThemeColor> getThemeColors() {
            return this.themeColors;
        }

        @Override // com.ss.android.lark.export.entity.preview.Gradient.Content
        public /* bridge */ /* synthetic */ Content clone() {
            return clone();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(Linear.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient.Linear");
            Linear r102 = (Linear) r100;
            if (Intrinsics.areEqual(this.deg, r102.deg) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.themeColors, r102.themeColors) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public final void setDeg(Integer r100) {
            this.deg = r100;
        }

        public final void setThemeColors(ArrayList<ThemeColor> r100) {
            this.themeColors = r100;
        }

        public Linear(Integer r100, ArrayList<ThemeColor> r101) {
            this.deg = r100;
            this.themeColors = r101;
        }

        public /* synthetic */ Linear(Integer r100, ArrayList r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Gradient() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Gradient copy$default(Gradient r100, GradientType r101, Content r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        return r100.copy(r101, r102);
    }

    public final GradientType component1() {
        return this.type;
    }

    public final Content component2() {
        return this.content;
    }

    public final Gradient copy(GradientType r100, Content r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "content");
        return new Gradient(r100, r101);
    }

    public String toString() {
        return "Gradient(type=" + this.type + ", content=" + this.content + ')';
    }

    public final Gradient clone() {
        return new Gradient(this.type, this.content.clone());
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.content.hashCode();
    }

    public final Content getContent() {
        return this.content;
    }

    public final GradientType getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(Gradient.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.export.entity.preview.Gradient");
        Gradient r102 = (Gradient) r100;
        if (this.type == r102.type) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.content, r102.content) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setContent(Content r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }

    public final void setType(GradientType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public Gradient(GradientType r100, Content r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.type = r100;
        this.content = r101;
    }

    public /* synthetic */ Gradient(GradientType r100, Content r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = GradientType.LINEAR;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = new Linear(0, null);
    L8:
        this(r100, r101);
    }
}
