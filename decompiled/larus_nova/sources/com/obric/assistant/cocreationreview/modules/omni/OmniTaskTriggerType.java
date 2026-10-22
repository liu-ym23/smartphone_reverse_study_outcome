package com.obric.assistant.cocreationreview.modules.omni;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/omni/OmniTaskTriggerType;", "", TemplateNodeType.RAW, "", "label", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "getLabel", "PROACTIVE", "AUTOMATIC", "MY_TASK", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniTaskTriggerType extends Enum<OmniTaskTriggerType> {
    public static final OmniTaskTriggerType AUTOMATIC = null;
    public static final a Companion = null;
    public static final OmniTaskTriggerType MY_TASK = null;
    public static final OmniTaskTriggerType PROACTIVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OmniTaskTriggerType[] f387458a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387459b = null;
    private final String label;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static OmniTaskTriggerType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
            OmniTaskTriggerType[] r101 = OmniTaskTriggerType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L13;
            OmniTaskTriggerType r104 = r101[r103];
            boolean r105 = true;
            if (Intrinsics.areEqual(r104.getRaw(), r100) == false) goto L7;
        L10:
            if (r105 == true) goto L14;
            r103 = r103 + 1;
        L14:
            if (r104 == null) goto L16;
            return r104;
        L16:
            return OmniTaskTriggerType.PROACTIVE;
        L7:
            if (StringsKt.equals(r104.name(), r100, true) == true) goto L10;
            r105 = false;
            goto L10
        L13:
            r104 = null;
            goto L14
        }
    }

    public static EnumEntries<OmniTaskTriggerType> getEntries() {
        return f387459b;
    }

    static {
        OmniTaskTriggerType r100 = new OmniTaskTriggerType("PROACTIVE", 0, "proactive", "主动任务");
        PROACTIVE = r100;
        OmniTaskTriggerType r101 = new OmniTaskTriggerType("AUTOMATIC", 1, "automatic", "自动任务");
        AUTOMATIC = r101;
        OmniTaskTriggerType r102 = new OmniTaskTriggerType("MY_TASK", 2, "my_task", "我的任务");
        MY_TASK = r102;
        OmniTaskTriggerType[] r103 = {r100, r101, r102};
        f387458a = r103;
        f387459b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static OmniTaskTriggerType[] values() {
        return (OmniTaskTriggerType[]) f387458a.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getRaw() {
        return this.raw;
    }

    public static OmniTaskTriggerType valueOf(String r100) {
        return (OmniTaskTriggerType) r27.a.a(OmniTaskTriggerType.class, r100);
    }

    public OmniTaskTriggerType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.raw = r102;
        this.label = r103;
    }
}
