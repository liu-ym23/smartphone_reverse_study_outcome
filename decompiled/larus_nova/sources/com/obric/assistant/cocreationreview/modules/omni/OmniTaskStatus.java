package com.obric.assistant.cocreationreview.modules.omni;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/omni/OmniTaskStatus;", "", TemplateNodeType.RAW, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "SUCCESS", "FAILED", "USER_STOPPED", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OmniTaskStatus extends Enum<OmniTaskStatus> {
    public static final a Companion = null;
    public static final OmniTaskStatus FAILED = null;
    public static final OmniTaskStatus SUCCESS = null;
    public static final OmniTaskStatus USER_STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OmniTaskStatus[] f387456a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387457b = null;
    private final String raw;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OmniTaskStatus> getEntries() {
        return f387457b;
    }

    static {
        OmniTaskStatus r100 = new OmniTaskStatus("SUCCESS", 0, "success");
        SUCCESS = r100;
        OmniTaskStatus r101 = new OmniTaskStatus("FAILED", 1, "failed");
        FAILED = r101;
        OmniTaskStatus r102 = new OmniTaskStatus("USER_STOPPED", 2, "user_stopped");
        USER_STOPPED = r102;
        OmniTaskStatus[] r103 = {r100, r101, r102};
        f387456a = r103;
        f387457b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static OmniTaskStatus[] values() {
        return (OmniTaskStatus[]) f387456a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static OmniTaskStatus valueOf(String r100) {
        return (OmniTaskStatus) r27.a.a(OmniTaskStatus.class, r100);
    }

    public OmniTaskStatus(String r100, int r101, String r102) {
        super(r100, r101);
        this.raw = r102;
    }
}
