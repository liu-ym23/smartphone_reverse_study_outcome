package com.larus.office.plugins.slides.orientation;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/office/plugins/slides/orientation/SlidesStates;", "", "states", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStates", "()Ljava/lang/String;", "EMPTY", EffectConstants.NORMAL, "GENERATING", "READ_ONLY", "PRESENTATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SlidesStates extends Enum<SlidesStates> {
    public static final SlidesStates EMPTY = null;
    public static final SlidesStates GENERATING = null;
    public static final SlidesStates NORMAL = null;
    public static final SlidesStates PRESENTATION = null;
    public static final SlidesStates READ_ONLY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SlidesStates[] f363451a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f363452b = null;
    private final String states;

    public static EnumEntries<SlidesStates> getEntries() {
        return f363452b;
    }

    static {
        SlidesStates r100 = new SlidesStates("EMPTY", 0, "empty");
        EMPTY = r100;
        SlidesStates r101 = new SlidesStates(EffectConstants.NORMAL, 1, "normal");
        NORMAL = r101;
        SlidesStates r102 = new SlidesStates("GENERATING", 2, "generating");
        GENERATING = r102;
        SlidesStates r103 = new SlidesStates("READ_ONLY", 3, "read_only");
        READ_ONLY = r103;
        SlidesStates r104 = new SlidesStates("PRESENTATION", 4, "presentation");
        PRESENTATION = r104;
        SlidesStates[] r105 = {r100, r101, r102, r103, r104};
        f363451a = r105;
        f363452b = EnumEntriesKt.enumEntries(r105);
    }

    public static SlidesStates[] values() {
        return (SlidesStates[]) f363451a.clone();
    }

    public final String getStates() {
        return this.states;
    }

    public static SlidesStates valueOf(String r100) {
        return (SlidesStates) r27.a.a(SlidesStates.class, r100);
    }

    public SlidesStates(String r100, int r101, String r102) {
        super(r100, r101);
        this.states = r102;
    }
}
