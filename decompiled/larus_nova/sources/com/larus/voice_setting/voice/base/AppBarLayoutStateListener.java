package com.larus.voice_setting.voice.base;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
public abstract class AppBarLayoutStateListener implements AppBarLayout.OnOffsetChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f376352a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "", "<init>", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "SCROLLING", "flow-voice-setting-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        public static final State COLLAPSED = null;
        public static final State EXPANDED = null;
        public static final State SCROLLING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ State[] f376353a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f376354b = null;

        public static EnumEntries<State> getEntries() {
            return f376354b;
        }

        static {
            State r100 = new State("EXPANDED", 0);
            EXPANDED = r100;
            State r101 = new State("COLLAPSED", 1);
            COLLAPSED = r101;
            State r102 = new State("SCROLLING", 2);
            SCROLLING = r102;
            State[] r103 = {r100, r101, r102};
            f376353a = r103;
            f376354b = EnumEntriesKt.enumEntries(r103);
        }

        public static State[] values() {
            return (State[]) f376353a.clone();
        }

        public static State valueOf(String r100) {
            return (State) r27.a.a(State.class, r100);
        }

        public State(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void a(AppBarLayout r100, State r101, State r102);

    public AppBarLayoutStateListener() {
        this.f376352a = State.EXPANDED;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
    public final void onOffsetChanged(AppBarLayout r100, int r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != 0) goto L9;
        State r102 = this.f376352a;
        State r103 = State.EXPANDED;
        if (r102 == r103) goto L17;
        a(r100, r102, r103);
        this.f376352a = r103;
        return;
    L17:
        return;
    L9:
        if (Math.abs(r101) < r100.getTotalScrollRange()) goto L13;
        State r104 = this.f376352a;
        State r105 = State.COLLAPSED;
        if (r104 == r105) goto L19;
        a(r100, r104, r105);
        this.f376352a = r105;
        return;
    L19:
        return;
    L13:
        State r106 = this.f376352a;
        State r107 = State.SCROLLING;
        if (r106 == r107) goto L21;
        a(r100, r106, r107);
        this.f376352a = r107;
        return;
    }
}
