package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$ZoomLevel;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SMALL", EffectConstants.NORMAL, "LARGE1", "LARGE2", "LARGE3", "LARGE4", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IUI$ZoomLevel extends Enum<IUI$ZoomLevel> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IUI$ZoomLevel[] $VALUES = null;
    public static final IUI$ZoomLevel LARGE1 = null;
    public static final IUI$ZoomLevel LARGE2 = null;
    public static final IUI$ZoomLevel LARGE3 = null;
    public static final IUI$ZoomLevel LARGE4 = null;
    public static final IUI$ZoomLevel NORMAL = null;
    public static final IUI$ZoomLevel SMALL = null;
    private final String value;

    private static final /* synthetic */ IUI$ZoomLevel[] $values() {
        return new IUI$ZoomLevel[]{SMALL, NORMAL, LARGE1, LARGE2, LARGE3, LARGE4};
    }

    public static EnumEntries<IUI$ZoomLevel> getEntries() {
        return $ENTRIES;
    }

    static {
        SMALL = new IUI$ZoomLevel("SMALL", 0, "SMALL");
        NORMAL = new IUI$ZoomLevel(EffectConstants.NORMAL, 1, EffectConstants.NORMAL);
        LARGE1 = new IUI$ZoomLevel("LARGE1", 2, "LARGE1");
        LARGE2 = new IUI$ZoomLevel("LARGE2", 3, "LARGE2");
        LARGE3 = new IUI$ZoomLevel("LARGE3", 4, "LARGE3");
        LARGE4 = new IUI$ZoomLevel("LARGE4", 5, "LARGE4");
        IUI$ZoomLevel[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IUI$ZoomLevel[] values() {
        return (IUI$ZoomLevel[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IUI$ZoomLevel valueOf(String r100) {
        return (IUI$ZoomLevel) a.a(IUI$ZoomLevel.class, r100);
    }

    private IUI$ZoomLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
