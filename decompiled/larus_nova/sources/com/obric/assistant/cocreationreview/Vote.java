package com.obric.assistant.cocreationreview;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/cocreationreview/Vote;", "", TemplateNodeType.RAW, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "UP", "DOWN", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Vote extends Enum<Vote> {
    public static final a Companion = null;
    public static final Vote DOWN = null;
    public static final Vote UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Vote[] f387172a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387173b = null;
    private final String raw;

    public static final class a {
        public a() {
        }

        public static Vote a(String r100) {
            Vote[] r101 = Vote.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            Vote r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getRaw(), r100) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    public static EnumEntries<Vote> getEntries() {
        return f387173b;
    }

    static {
        Vote r100 = new Vote("UP", 0, "up");
        UP = r100;
        Vote r101 = new Vote("DOWN", 1, ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN);
        DOWN = r101;
        Vote[] r102 = {r100, r101};
        f387172a = r102;
        f387173b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static Vote[] values() {
        return (Vote[]) f387172a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static Vote valueOf(String r100) {
        return (Vote) r27.a.a(Vote.class, r100);
    }

    public Vote(String r100, int r101, String r102) {
        super(r100, r101);
        this.raw = r102;
    }
}
