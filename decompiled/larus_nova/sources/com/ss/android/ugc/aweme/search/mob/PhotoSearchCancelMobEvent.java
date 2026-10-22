package com.ss.android.ugc.aweme.search.mob;

import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.ugc.aweme.search.mob.base.BaseMobEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/PhotoSearchCancelMobEvent;", "", "<init>", "()V", "CancelTabClick", "CancelTabShow", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchCancelMobEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PhotoSearchCancelMobEvent f453319a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/PhotoSearchCancelMobEvent$CancelTabClick;", "Lcom/ss/android/ugc/aweme/search/mob/base/BaseMobEvent;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CancelTabClick extends BaseMobEvent<CancelTabClick> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/PhotoSearchCancelMobEvent$CancelTabClick$Companion;", "", "()V", AlarmSessionType.EVENT, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(int r100) {
                this();
            }
        }

        static {
            new Companion(0);
        }

        public CancelTabClick() {
            super("cancel_tab_click");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/PhotoSearchCancelMobEvent$CancelTabShow;", "Lcom/ss/android/ugc/aweme/search/mob/base/BaseMobEvent;", "<init>", "()V", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CancelTabShow extends BaseMobEvent<CancelTabShow> {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/PhotoSearchCancelMobEvent$CancelTabShow$Companion;", "", "()V", AlarmSessionType.EVENT, "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(int r100) {
                this();
            }
        }

        static {
            new Companion(0);
        }

        public CancelTabShow() {
            super("cancel_tab_show");
        }
    }

    private PhotoSearchCancelMobEvent() {
    }

    static {
        f453319a = new PhotoSearchCancelMobEvent();
    }
}
