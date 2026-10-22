package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/FontType;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "TITLE", "HEADLINE", "BODY", "CAPTION", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FontType extends Enum<FontType> implements Serializable {
    public static final FontType BODY = null;
    public static final FontType CAPTION = null;
    public static final a Companion = null;
    public static final FontType HEADLINE = null;
    public static final FontType TITLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FontType[] f420662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420663b = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<FontType> getEntries() {
        return f420663b;
    }

    static {
        FontType r100 = new FontType("TITLE", 0, 0);
        TITLE = r100;
        FontType r101 = new FontType("HEADLINE", 1, 1);
        HEADLINE = r101;
        FontType r102 = new FontType("BODY", 2, 2);
        BODY = r102;
        FontType r103 = new FontType("CAPTION", 3, 3);
        CAPTION = r103;
        FontType[] r104 = {r100, r101, r102, r103};
        f420662a = r104;
        f420663b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static FontType[] values() {
        return (FontType[]) f420662a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static FontType valueOf(String r100) {
        return (FontType) r27.a.a(FontType.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public FontType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
