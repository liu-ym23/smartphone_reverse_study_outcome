package com.lynx.clay.embedding.android;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.texturerender.VideoSurfaceTexture;

/* JADX INFO: loaded from: classes32.dex */
public final enum RenderMode extends Enum<RenderMode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RenderMode[] f380590a = null;
    public static final RenderMode delegate = null;
    public static final RenderMode image = null;
    public static final RenderMode surface = null;
    public static final RenderMode sync = null;
    public static final RenderMode texture = null;

    static {
        RenderMode r100 = new RenderMode("surface", 0);
        surface = r100;
        RenderMode r101 = new RenderMode(VideoSurfaceTexture.KEY_TEXTURE, 1);
        texture = r101;
        RenderMode r102 = new RenderMode("image", 2);
        image = r102;
        RenderMode r103 = new RenderMode(DocumentType.DOCX_SYNC_BLOCK_NAME, 3);
        sync = r103;
        RenderMode r104 = new RenderMode("delegate", 4);
        delegate = r104;
        f380590a = new RenderMode[]{r100, r101, r102, r103, r104};
    }

    public static RenderMode[] values() {
        return (RenderMode[]) f380590a.clone();
    }

    public static RenderMode valueOf(String r100) {
        return (RenderMode) r27.a.a(RenderMode.class, r100);
    }

    public RenderMode(String r100, int r101) {
        super(r100, r101);
    }
}
