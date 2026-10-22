package com.ss.android.lark.export.entity.preview;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \u000e2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/SizeLevel;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", EffectConstants.NORMAL, "SMALL", "LARGE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SizeLevel extends Enum<SizeLevel> implements Serializable {
    public static final a Companion = null;
    public static final SizeLevel LARGE = null;
    public static final SizeLevel NORMAL = null;
    public static final SizeLevel SMALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SizeLevel[] f420666a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420667b = null;
    private int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<SizeLevel> getEntries() {
        return f420667b;
    }

    static {
        SizeLevel r100 = new SizeLevel(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        SizeLevel r101 = new SizeLevel("SMALL", 1, 1);
        SMALL = r101;
        SizeLevel r102 = new SizeLevel("LARGE", 2, 2);
        LARGE = r102;
        SizeLevel[] r103 = {r100, r101, r102};
        f420666a = r103;
        f420667b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static SizeLevel[] values() {
        return (SizeLevel[]) f420666a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SizeLevel valueOf(String r100) {
        return (SizeLevel) r27.a.a(SizeLevel.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public SizeLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
