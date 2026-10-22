package com.ss.android.lark.export.entity;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/export/entity/WidthMode;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COMPACT", "SPACIOUS", "FILL", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidthMode extends Enum<WidthMode> {
    public static final WidthMode COMPACT = null;
    public static final a Companion = null;
    public static final WidthMode FILL = null;
    public static final WidthMode SPACIOUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidthMode[] f420658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420659b = null;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static WidthMode a(String r100) {
            WidthMode r101 = WidthMode.SPACIOUS;
            if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L10;
            WidthMode r102 = WidthMode.FILL;
            if (Intrinsics.areEqual(r100, r102.getValue()) == false) goto L9;
            return r102;
        L9:
            return WidthMode.COMPACT;
        L10:
            return r101;
        }
    }

    @JvmStatic
    public static final WidthMode forString(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public static EnumEntries<WidthMode> getEntries() {
        return f420659b;
    }

    static {
        WidthMode r100 = new WidthMode("COMPACT", 0, "compact");
        COMPACT = r100;
        WidthMode r101 = new WidthMode("SPACIOUS", 1, "spacious");
        SPACIOUS = r101;
        WidthMode r102 = new WidthMode("FILL", 2, LynxVideoManagerLite.FILL);
        FILL = r102;
        WidthMode[] r103 = {r100, r101, r102};
        f420658a = r103;
        f420659b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static WidthMode[] values() {
        return (WidthMode[]) f420658a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static WidthMode valueOf(String r100) {
        return (WidthMode) r27.a.a(WidthMode.class, r100);
    }

    public WidthMode(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
