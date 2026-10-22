package com.bytedance.locallife.photo.internal.photodraweeview;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/locallife/photo/internal/photodraweeview/DismissAnimationType;", "", "BG_ALPHA_IMG_ALPHA", UserProfileEvent.POSITION_NONE, "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum DismissAnimationType extends Enum<DismissAnimationType> {
    public static final DismissAnimationType BG_ALPHA_IMG_ALPHA = null;
    public static final DismissAnimationType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DismissAnimationType[] f262036a = null;

    public static DismissAnimationType valueOf(String r100) {
        return (DismissAnimationType) a.a(DismissAnimationType.class, r100);
    }

    public static DismissAnimationType[] values() {
        return (DismissAnimationType[]) f262036a.clone();
    }

    static {
        DismissAnimationType r100 = new DismissAnimationType("BG_ALPHA_IMG_ALPHA", 0);
        BG_ALPHA_IMG_ALPHA = r100;
        DismissAnimationType r101 = new DismissAnimationType(UserProfileEvent.POSITION_NONE, 1);
        NONE = r101;
        f262036a = new DismissAnimationType[]{r100, r101};
    }

    public DismissAnimationType(String r100, int r101) {
        super(r100, r101);
    }
}
