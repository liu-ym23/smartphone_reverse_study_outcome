package com.ss.android.vesdk.frame;

import android.graphics.SurfaceTexture;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TEFrameSizei;

/* JADX INFO: loaded from: classes40.dex */
public final class TETextureCapturePipeline extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f455827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SurfaceTexture f455828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SURFACE_OPERATION f455829i;

    public static final enum SURFACE_OPERATION extends Enum<SURFACE_OPERATION> {
        public static final SURFACE_OPERATION ADD_SURFACE = null;
        public static final SURFACE_OPERATION ADD_SURFACE_TEXTURE = null;
        public static final SURFACE_OPERATION CHANGE_SURFACE = null;
        public static final SURFACE_OPERATION NONE = null;
        public static final SURFACE_OPERATION REMOVE_SURFACE = null;
        public static final SURFACE_OPERATION REMOVE_SURFACE_TEXTURE = null;
        public static final SURFACE_OPERATION SURFACETEXTUREID = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SURFACE_OPERATION[] f455830a = null;

        static {
            SURFACE_OPERATION r100 = new SURFACE_OPERATION(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            SURFACE_OPERATION r101 = new SURFACE_OPERATION("ADD_SURFACE", 1);
            ADD_SURFACE = r101;
            SURFACE_OPERATION r102 = new SURFACE_OPERATION("CHANGE_SURFACE", 2);
            CHANGE_SURFACE = r102;
            SURFACE_OPERATION r103 = new SURFACE_OPERATION("REMOVE_SURFACE", 3);
            REMOVE_SURFACE = r103;
            SURFACE_OPERATION r104 = new SURFACE_OPERATION("ADD_SURFACE_TEXTURE", 4);
            ADD_SURFACE_TEXTURE = r104;
            SURFACE_OPERATION r105 = new SURFACE_OPERATION("REMOVE_SURFACE_TEXTURE", 5);
            REMOVE_SURFACE_TEXTURE = r105;
            SURFACE_OPERATION r110 = new SURFACE_OPERATION("SURFACETEXTUREID", 6);
            SURFACETEXTUREID = r110;
            f455830a = new SURFACE_OPERATION[]{r100, r101, r102, r103, r104, r105, r110};
        }

        public static SURFACE_OPERATION[] values() {
            return (SURFACE_OPERATION[]) f455830a.clone();
        }

        public static SURFACE_OPERATION valueOf(String r100) {
            return (SURFACE_OPERATION) r27.a.a(SURFACE_OPERATION.class, r100);
        }

        public SURFACE_OPERATION(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // com.ss.android.vesdk.frame.b
    public final boolean b() {
        return super.b();
    }

    @Override // com.ss.android.vesdk.frame.b
    public final SurfaceTexture a() {
        return this.f455828h;
    }

    @Override // com.ss.android.vesdk.frame.b
    public final void c(SurfaceTexture r100) {
        this.f455828h = r100;
    }

    public TETextureCapturePipeline(TEFrameSizei r100, b.InterfaceC5458b r101, boolean r102, int r110, SurfaceTexture r111) {
        super(TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES, r100, r101, r102, r111);
        this.f455829i = SURFACE_OPERATION.NONE;
        this.f455827g = r110;
        this.f455828h = r111;
    }
}
