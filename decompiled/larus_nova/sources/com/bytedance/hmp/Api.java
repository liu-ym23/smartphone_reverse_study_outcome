package com.bytedance.hmp;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class Api {
    private static final String sJniLib = "_jhmp";

    public Api() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native int color_model_ctc(long r100);

    public static native void color_model_free(long r100);

    public static native long color_model_make(int r100, int r101, int r102, int r103);

    public static native int color_model_primaries(long r100);

    public static native int color_model_range(long r100);

    public static native int color_model_space(long r100);

    public static native int device_count(int r100);

    public static native void device_free(long r100);

    public static native void device_guard_free(long r100);

    public static native long device_guard_make(long r100);

    public static native int device_index(long r100);

    public static native long device_make(int r100, int r101);

    public static native long device_make(String r100);

    public static native String device_stringfy(long r100);

    public static native int device_type(long r100);

    public static native long frame_clone(long r100);

    public static native void frame_copy_from(long r100, long r101);

    public static native long frame_crop(long r100, int r101, int r102, int r103, int r104);

    public static native boolean frame_defined(long r100);

    public static native int frame_device_index(long r100);

    public static native int frame_device_type(long r100);

    public static native int frame_dtype(long r100);

    public static native int frame_format(long r100);

    public static native void frame_free(long r100);

    public static native long frame_from_image(long r100, long r101);

    public static native int frame_height(long r100);

    public static native long frame_make(int r100, int r101, long r102, String r103);

    public static native long frame_make(Bitmap r100);

    public static native long frame_make(long[] r100, int r101, int r102, long r103);

    public static native long frame_make(long[] r100, long r101);

    public static native int frame_nplanes(long r100);

    public static native long frame_pix_info(long r100);

    public static native long frame_plane(long r100, int r101);

    public static native String frame_stringfy(long r100);

    public static native long frame_to_device(long r100, String r101, boolean r102);

    public static native long frame_to_image(long r100, int r101);

    public static native void frame_unlock(Bitmap r100);

    public static native int frame_width(long r100);

    public static native int image_cdim(long r100);

    public static native long image_clone(long r100);

    public static native long image_color_model(long r100);

    public static native void image_copy_from(long r100, long r101);

    public static native long image_crop(long r100, int r101, int r102, int r103, int r104);

    public static native long image_data(long r100);

    public static native boolean image_defined(long r100);

    public static native int image_device_index(long r100);

    public static native int image_device_type(long r100);

    public static native int image_dtype(long r100);

    public static native int image_format(long r100);

    public static native void image_free(long r100);

    public static native int image_hdim(long r100);

    public static native int image_height(long r100);

    public static native long image_make(int r100, int r101, int r102, int r103, int r104, String r105, boolean r106);

    public static native long image_make(long r100, int r101);

    public static native long image_make(long r100, int r101, long r102);

    public static native int image_nchannels(long r100);

    public static native void image_set_color_model(long r100, long r101);

    public static native String image_stringfy(long r100);

    public static native long image_to_device(long r100, String r101, boolean r102);

    public static native long image_to_dtype(long r100, int r101);

    public static native int image_wdim(long r100);

    public static native int image_width(long r100);

    public static native int pixel_format_desc_channels(long r100, int r101);

    public static native int pixel_format_desc_dtype(long r100);

    public static native int pixel_format_desc_format(long r100);

    public static native void pixel_format_desc_free(long r100);

    public static native int pixel_format_desc_infer_height(long r100, int r101, int r102);

    public static native int pixel_format_desc_infer_nitems(long r100, int r101, int r102);

    public static native int pixel_format_desc_infer_nitems(long r100, int r101, int r102, int r103);

    public static native int pixel_format_desc_infer_width(long r100, int r101, int r102);

    public static native long pixel_format_desc_make(int r100);

    public static native int pixel_format_desc_nplanes(long r100);

    public static native long pixel_info_color_model(long r100);

    public static native int pixel_info_ctc(long r100);

    public static native int pixel_info_format(long r100);

    public static native void pixel_info_free(long r100);

    public static native int pixel_info_infer_space(long r100);

    public static native boolean pixel_info_is_rgbx(long r100);

    public static native long pixel_info_make(int r100, int r101, int r102);

    public static native long pixel_info_make(int r100, long r101);

    public static native int pixel_info_primaries(long r100);

    public static native int pixel_info_range(long r100);

    public static native int pixel_info_space(long r100);

    public static native String pixel_info_stringfy(long r100);

    public static native long scalar(double r100);

    public static native long scalar(long r100);

    public static native long scalar(boolean r100);

    public static native void scalar_free(long r100);

    public static native long stream_current(int r100);

    public static native int stream_device_index(long r100);

    public static native int stream_device_type(long r100);

    public static native void stream_free(long r100);

    public static native long stream_guard_create(long r100);

    public static native void stream_guard_free(long r100);

    public static native long stream_handle(long r100);

    public static native long stream_make(int r100, long r101);

    public static native boolean stream_query(long r100);

    public static native void stream_set_current(long r100);

    public static native void stream_synchronize(long r100);

    public static native long tensor_alias(long r100);

    public static native long tensor_arange(long r100, long r101, long r102, int r103, String r104, boolean r105);

    public static native long tensor_clone(long r100);

    public static native void tensor_copy_from(long r100, long r101);

    public static native long tensor_data_ptr(long r100);

    public static native boolean tensor_defined(long r100);

    public static native int tensor_device_index(long r100);

    public static native int tensor_device_type(long r100);

    public static native long tensor_dim(long r100);

    public static native int tensor_dtype(long r100);

    public static native long tensor_empty(long[] r100, int r101, String r102, boolean r103);

    public static native void tensor_fill(long r100, long r101);

    public static native void tensor_free(long r100);

    public static native long tensor_from_file(String r100, int r101, long r102, long r103);

    public static native boolean tensor_is_contiguous(long r100);

    public static native long tensor_itemsize(long r100);

    public static native long tensor_nbytes(long r100);

    public static native long tensor_nitems(long r100);

    public static native long tensor_permute(long r100, long[] r101);

    public static native long tensor_reshape(long r100, long[] r101);

    public static native long tensor_select(long r100, long r101, long r102);

    public static native long tensor_size(long r100, long r101);

    public static native long tensor_slice(long r100, long r101, long r102, long r103, long r104);

    public static native long tensor_squeeze(long r100, long r101);

    public static native long tensor_stride(long r100, long r101);

    public static native String tensor_stringfy(long r100);

    public static native long tensor_to_device(long r100, String r101, boolean r102);

    public static native long tensor_to_dtype(long r100, int r101);

    public static native void tensor_to_file(long r100, String r101);

    public static native long tensor_unsqueeze(long r100, long r101);

    public static native long tensor_view(long r100, long[] r101);

    static {
        INVOKESTATIC_com_bytedance_hmp_Api_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(sJniLib);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_hmp_Api_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
