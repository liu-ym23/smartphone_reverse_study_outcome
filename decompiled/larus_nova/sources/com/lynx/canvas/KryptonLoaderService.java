package com.lynx.canvas;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public abstract class KryptonLoaderService extends KryptonService {

    public interface DataResolver {
        void reject(String r100);

        void resolve(byte[] r100, int r101, int r102);
    }

    public static final class ImageLoadOptions {
        public final boolean decodeImageInJs;
        public final boolean usingBuiltinImageDecoder;

        public static ImageLoadOptions defaults() {
            return new ImageLoadOptions(false, false);
        }

        public ImageLoadOptions(boolean r100, boolean r101) {
            this.decodeImageInJs = r100;
            this.usingBuiltinImageDecoder = r101;
        }
    }

    public interface ImageResolver {
        void reject(String r100);

        void resolve(Bitmap r100);
    }

    public static final enum LoadPolicy extends Enum<LoadPolicy> {
        private static final /* synthetic */ LoadPolicy[] $VALUES = null;
        public static final LoadPolicy DEFAULT_ASYNC = null;
        public static final LoadPolicy PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI = null;

        static {
            LoadPolicy r100 = new LoadPolicy("DEFAULT_ASYNC", 0);
            DEFAULT_ASYNC = r100;
            LoadPolicy r101 = new LoadPolicy("PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI", 1);
            PREFER_CURRENT_THREAD_FOR_LOCAL_OR_DATA_URI = r101;
            $VALUES = new LoadPolicy[]{r100, r101};
        }

        public static LoadPolicy[] values() {
            return (LoadPolicy[]) $VALUES.clone();
        }

        public static LoadPolicy valueOf(String r100) {
            return (LoadPolicy) a.a(LoadPolicy.class, r100);
        }

        private LoadPolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface StreamDelegate {
        void onData(byte[] r100, int r101, int r102);

        void onEnd();

        void onError(String r100);

        void onStart(int r100);
    }

    public static final enum TextureUploadFunctionType extends Enum<TextureUploadFunctionType> {
        private static final /* synthetic */ TextureUploadFunctionType[] $VALUES = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_IMAGE_2D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_IMAGE_3D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_SUB_IMAGE_2D = null;
        public static final TextureUploadFunctionType COMPRESSED_TEX_SUB_IMAGE_3D = null;
        public static final TextureUploadFunctionType TEX_IMAGE_2D = null;
        public static final TextureUploadFunctionType TEX_IMAGE_3D = null;
        public static final TextureUploadFunctionType TEX_SUB_IMAGE_2D = null;
        public static final TextureUploadFunctionType TEX_SUB_IMAGE_3D = null;

        static {
            TextureUploadFunctionType r100 = new TextureUploadFunctionType("TEX_IMAGE_2D", 0);
            TEX_IMAGE_2D = r100;
            TextureUploadFunctionType r101 = new TextureUploadFunctionType("TEX_SUB_IMAGE_2D", 1);
            TEX_SUB_IMAGE_2D = r101;
            TextureUploadFunctionType r102 = new TextureUploadFunctionType("TEX_IMAGE_3D", 2);
            TEX_IMAGE_3D = r102;
            TextureUploadFunctionType r103 = new TextureUploadFunctionType("TEX_SUB_IMAGE_3D", 3);
            TEX_SUB_IMAGE_3D = r103;
            TextureUploadFunctionType r104 = new TextureUploadFunctionType("COMPRESSED_TEX_IMAGE_2D", 4);
            COMPRESSED_TEX_IMAGE_2D = r104;
            TextureUploadFunctionType r105 = new TextureUploadFunctionType("COMPRESSED_TEX_SUB_IMAGE_2D", 5);
            COMPRESSED_TEX_SUB_IMAGE_2D = r105;
            TextureUploadFunctionType r110 = new TextureUploadFunctionType("COMPRESSED_TEX_IMAGE_3D", 6);
            COMPRESSED_TEX_IMAGE_3D = r110;
            TextureUploadFunctionType r111 = new TextureUploadFunctionType("COMPRESSED_TEX_SUB_IMAGE_3D", 7);
            COMPRESSED_TEX_SUB_IMAGE_3D = r111;
            $VALUES = new TextureUploadFunctionType[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static TextureUploadFunctionType[] values() {
            return (TextureUploadFunctionType[]) $VALUES.clone();
        }

        public static TextureUploadFunctionType valueOf(String r100) {
            return (TextureUploadFunctionType) a.a(TextureUploadFunctionType.class, r100);
        }

        private TextureUploadFunctionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class TextureUploadRequest {
        public final int border;
        public final int depth;
        public final int format;
        public final TextureUploadFunctionType functionType;
        public final int height;
        public final int internalformat;
        public final int level;
        public final long sourceByteLength;
        public final ByteBuffer sourceData;
        public final TextureUploadSourceViewType sourceViewType;
        public final long srcLengthOverride;
        public final long srcOffset;
        public final int target;
        public final int type;
        public final int width;
        public final int xoffset;
        public final int yoffset;
        public final int zoffset;

        public TextureUploadRequest(int r100, int r101, int r102, int r103, int r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115, int r116, long r117, long r118, int r210, long r211, ByteBuffer r212) {
            this.functionType = TextureUploadFunctionType.values()[r100];
            this.target = r101;
            this.level = r102;
            this.internalformat = r103;
            this.width = r104;
            this.height = r105;
            this.depth = r110;
            this.border = r111;
            this.format = r112;
            this.type = r113;
            this.xoffset = r114;
            this.yoffset = r115;
            this.zoffset = r116;
            this.srcOffset = r117;
            this.srcLengthOverride = r118;
            this.sourceViewType = TextureUploadSourceViewType.values()[r210];
            this.sourceByteLength = r211;
            if (r212 != null) goto L5;
            ByteBuffer r106 = null;
        L6:
            this.sourceData = r106;
            return;
        L5:
            r106 = r212.asReadOnlyBuffer();
            goto L6
        }
    }

    public static final enum TextureUploadSourceViewType extends Enum<TextureUploadSourceViewType> {
        private static final /* synthetic */ TextureUploadSourceViewType[] $VALUES = null;
        public static final TextureUploadSourceViewType BIG_INT64 = null;
        public static final TextureUploadSourceViewType BIG_UINT64 = null;
        public static final TextureUploadSourceViewType DATA_VIEW = null;
        public static final TextureUploadSourceViewType EMPTY = null;
        public static final TextureUploadSourceViewType FLOAT32 = null;
        public static final TextureUploadSourceViewType FLOAT64 = null;
        public static final TextureUploadSourceViewType INT16 = null;
        public static final TextureUploadSourceViewType INT32 = null;
        public static final TextureUploadSourceViewType INT8 = null;
        public static final TextureUploadSourceViewType UINT16 = null;
        public static final TextureUploadSourceViewType UINT32 = null;
        public static final TextureUploadSourceViewType UINT8 = null;
        public static final TextureUploadSourceViewType UINT8_CLAMPED = null;

        static {
            TextureUploadSourceViewType r100 = new TextureUploadSourceViewType("EMPTY", 0);
            EMPTY = r100;
            TextureUploadSourceViewType r101 = new TextureUploadSourceViewType("INT8", 1);
            INT8 = r101;
            TextureUploadSourceViewType r102 = new TextureUploadSourceViewType("UINT8", 2);
            UINT8 = r102;
            TextureUploadSourceViewType r103 = new TextureUploadSourceViewType("UINT8_CLAMPED", 3);
            UINT8_CLAMPED = r103;
            TextureUploadSourceViewType r104 = new TextureUploadSourceViewType("INT16", 4);
            INT16 = r104;
            TextureUploadSourceViewType r105 = new TextureUploadSourceViewType("UINT16", 5);
            UINT16 = r105;
            TextureUploadSourceViewType r110 = new TextureUploadSourceViewType("INT32", 6);
            INT32 = r110;
            TextureUploadSourceViewType r111 = new TextureUploadSourceViewType("UINT32", 7);
            UINT32 = r111;
            TextureUploadSourceViewType r112 = new TextureUploadSourceViewType("FLOAT32", 8);
            FLOAT32 = r112;
            TextureUploadSourceViewType r113 = new TextureUploadSourceViewType("FLOAT64", 9);
            FLOAT64 = r113;
            TextureUploadSourceViewType r114 = new TextureUploadSourceViewType("BIG_INT64", 10);
            BIG_INT64 = r114;
            TextureUploadSourceViewType r115 = new TextureUploadSourceViewType("BIG_UINT64", 11);
            BIG_UINT64 = r115;
            TextureUploadSourceViewType r106 = new TextureUploadSourceViewType("DATA_VIEW", 12);
            DATA_VIEW = r106;
            $VALUES = new TextureUploadSourceViewType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
        }

        public static TextureUploadSourceViewType[] values() {
            return (TextureUploadSourceViewType[]) $VALUES.clone();
        }

        public static TextureUploadSourceViewType valueOf(String r100) {
            return (TextureUploadSourceViewType) a.a(TextureUploadSourceViewType.class, r100);
        }

        private TextureUploadSourceViewType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public byte[] loadUrlSync(String r100) {
        return null;
    }

    public abstract void loadUrlWithDataResolver(String r100, DataResolver r101);

    public abstract void loadUrlWithImageResolver(String r100, ImageResolver r101);

    public void onGetSupportedExtensions(String[] r100) {
    }

    public byte[] overrideTextureUpload(TextureUploadRequest r100) {
        return null;
    }

    public abstract String redirectUrl(String r100);

    public KryptonLoaderService() {
    }

    public void loadUrlWithStreamDelegate(String r100, StreamDelegate r101) {
        throw new UnsupportedOperationException();
    }

    public void loadImageWithOptions(String r100, ImageLoadOptions r101, ImageResolver r102) {
        throw new UnsupportedOperationException();
    }

    public void loadUrlWithDataResolverWithPolicy(String r100, DataResolver r101, LoadPolicy r102) {
        loadUrlWithDataResolver(r100, r101);
    }
}
