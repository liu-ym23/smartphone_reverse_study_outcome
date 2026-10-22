package com.obric.common.oea.style.scene.qsanim.pulldown;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
public abstract class AbstractQSPullDownAnimHelper extends com.obric.common.oea.style.scene.qsanim.pulldown.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f396666a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/common/oea/style/scene/qsanim/pulldown/AbstractQSPullDownAnimHelper$DragUpAnimPhase;", "", UserProfileEvent.POSITION_NONE, "OPEN", "CLOSE", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DragUpAnimPhase extends Enum<DragUpAnimPhase> {
        public static final DragUpAnimPhase CLOSE = null;
        public static final DragUpAnimPhase NONE = null;
        public static final DragUpAnimPhase OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DragUpAnimPhase[] f396667a = null;

        static {
            DragUpAnimPhase r100 = new DragUpAnimPhase(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            DragUpAnimPhase r101 = new DragUpAnimPhase("OPEN", 1);
            OPEN = r101;
            DragUpAnimPhase r102 = new DragUpAnimPhase("CLOSE", 2);
            CLOSE = r102;
            f396667a = new DragUpAnimPhase[]{r100, r101, r102};
        }

        public static DragUpAnimPhase valueOf(String r100) {
            return (DragUpAnimPhase) r27.a.a(DragUpAnimPhase.class, r100);
        }

        public static DragUpAnimPhase[] values() {
            return (DragUpAnimPhase[]) f396667a.clone();
        }

        public DragUpAnimPhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }
}
