package com.ss.texturerender;

import android.opengl.GLES20;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public class TextureFactory implements Texture.OnTextureReturnListener {
    private static final String TAG = "TextureFactory";
    private TextureRenderer mTextureRenderer;
    private ArrayList<ITexture> mTextures;

    public void release() {
        ArrayList<ITexture> r100 = this.mTextures;
        monitor-enter(r100);
        Iterator<ITexture> r101 = this.mTextures.iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        ((Texture) r101.next()).release();     // Catch: Throwable -> L10
        r101.remove();     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public TextureFactory(TextureRenderer r100) {
        this.mTextures = new ArrayList();
        this.mTextureRenderer = r100;
    }

    private static int loadTexture(int r100) {
        int[] r101 = new int[1];
        GLES20.glGenTextures(1, r101, 0);
        int r102 = r101[0];
        if (r102 == 0) goto L14;
        if (r102 == 0) goto L12;
        GLES20.glBindTexture(r100, r102);
        GLES20.glTexParameteri(r100, 10242, 33071);
        GLES20.glTexParameteri(r100, 10243, 33071);
        if (r100 == 36197) goto L8;
    L10:
        GLES20.glTexParameteri(r100, 10241, 9729);
        GLES20.glTexParameteri(r100, 10240, 9729);
        goto L12
    L8:
        if (DeviceManager.isVRDevice() == false) goto L10;
        GLES20.glTexParameteri(r100, 10241, 9728);
        GLES20.glTexParameteri(r100, 10240, 9728);
    L12:
        return r101[0];
    L14:
        throw new RuntimeException("Error gen texture.");
    }

    @Override // com.ss.texturerender.Texture.OnTextureReturnListener
    public void onTextureReturn(ITexture r100) {
        ArrayList<ITexture> r101 = this.mTextures;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (((Texture) r100).getForbidTextureReuse() <= 0) goto L10;
        TextureRenderer r102 = this.mTextureRenderer;     // Catch: Throwable -> L16
        if (r102 == null) goto L9;
        TextureRenderLog.i(r102.texType(), TAG, "release texture = " + r100);     // Catch: Throwable -> L16
    L9:
        ((Texture) r100).release();     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L10:
        TextureRenderer r103 = this.mTextureRenderer;     // Catch: Throwable -> L16
        if (r103 == null) goto L13;
        TextureRenderLog.i(r103.texType(), TAG, "add texture = " + r100 + "size = " + this.mTextures.size());     // Catch: Throwable -> L16
    L13:
        this.mTextures.add(r100);     // Catch: Throwable -> L16
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.ss.texturerender.IRef, com.ss.texturerender.ITexture] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.texturerender.Texture] */
    /* JADX WARN: Type inference failed for: r2v7 */
    public ITexture createTexture(int r100, int r101) {
        ArrayList<ITexture> r102 = this.mTextures;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.mTextures.size() <= 0) goto L12;
        Iterator<ITexture> r103 = this.mTextures.iterator();     // Catch: Throwable -> L18
    L8:
        if (r103.hasNext() == false) goto L12;
        ITexture r104 = r103.next();     // Catch: Throwable -> L18
        if (r104.getTexTarget() != r100) goto L8;
        r103.remove();     // Catch: Throwable -> L18
        r104.toString();     // Catch: Throwable -> L18
        r104.getTexTarget();     // Catch: Throwable -> L18
        ?? r105 = r104;
    L13:
        if (r105 != 0) goto L15;
        r105 = new Texture(loadTexture(r100), r100, this, r101);     // Catch: Throwable -> L18
        r105.toString();     // Catch: Throwable -> L18
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L18
        r105.addRef();
        return r105;
    L12:
        r105 = 0;
        goto L13
    }
}
