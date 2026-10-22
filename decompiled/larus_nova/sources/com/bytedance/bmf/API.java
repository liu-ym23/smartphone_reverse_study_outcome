package com.bytedance.bmf;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public class API {
    private static final String LIBBMFMODULESDK = "_jbmf";

    public API() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native void bmf_af_copy_props(long r100, long r101);

    public static native boolean bmf_af_defined(long r100);

    public static native int bmf_af_dtype(long r100);

    public static native void bmf_af_free(long r100);

    public static native long bmf_af_make(int r100, int r101, boolean r102, int r103);

    public static native long bmf_af_make_from_data(long[] r100, int r101, int r102, boolean r103);

    public static native int bmf_af_nchannels(long r100);

    public static native int bmf_af_nplanes(long r100);

    public static native int bmf_af_nsamples(long r100);

    public static native long bmf_af_plane(long r100, int r101);

    public static native boolean bmf_af_planer(long r100);

    public static native long[] bmf_af_planes(long r100);

    public static native void bmf_af_private_attach_json_param(long r100, long r101);

    public static native long bmf_af_private_get_json_param(long r100);

    public static native void bmf_af_private_merge(long r100, long r101);

    public static native long bmf_af_pts(long r100);

    public static native float bmf_af_sample_rate(long r100);

    public static native void bmf_af_set_pts(long r100, long r101);

    public static native void bmf_af_set_sample_rate(long r100, float r101);

    public static native void bmf_af_set_time_base(long r100, int r101, int r102);

    public static native int[] bmf_af_time_base(long r100);

    public static native String bmf_json_dump(long r100);

    public static native boolean bmf_json_erase(long r100, String r101);

    public static native void bmf_json_free(long r100);

    public static native double bmf_json_get_double(long r100, String r101);

    public static native double[] bmf_json_get_double_list(long r100, String r101);

    public static native float bmf_json_get_float(long r100, String r101);

    public static native float[] bmf_json_get_float_list(long r100, String r101);

    public static native int bmf_json_get_int(long r100, String r101);

    public static native int[] bmf_json_get_int_list(long r100, String r101);

    public static native long bmf_json_get_long(long r100, String r101);

    public static native String bmf_json_get_string(long r100, String r101);

    public static native String[] bmf_json_get_string_list(long r100, String r101);

    public static native boolean bmf_json_has_key(long r100, String r101);

    public static native long bmf_json_make();

    public static native String bmf_json_param_dump(long r100);

    public static native long bmf_json_param_parse(String r100);

    public static native void bmf_json_set_double(long r100, String r101, double r102);

    public static native void bmf_json_set_double_list(long r100, String r101, double[] r102);

    public static native void bmf_json_set_float(long r100, String r101, float r102);

    public static native void bmf_json_set_float_list(long r100, String r101, float[] r102);

    public static native void bmf_json_set_int(long r100, String r101, int r102);

    public static native void bmf_json_set_int_list(long r100, String r101, int[] r102);

    public static native void bmf_json_set_long(long r100, String r101, long r102);

    public static native void bmf_json_set_string(long r100, String r101, String r102);

    public static native void bmf_json_set_string_list(long r100, String r101, String[] r102);

    public static native long[] bmf_module_functor_call(long r100, long[] r101);

    public static native void bmf_module_functor_execute(long r100, long[] r101, boolean r102);

    public static native long[] bmf_module_functor_fetch(long r100, int r101);

    public static native void bmf_module_functor_free(long r100);

    public static native long bmf_module_functor_make(String r100, String r101, String r102, String r103, String r104, int r105, int r106, int r107);

    public static native int bmf_packet_defined(long r100);

    public static native void bmf_packet_free(long r100);

    public static native long bmf_packet_from_json_param(long r100);

    public static native long bmf_packet_from_json_str(String r100);

    public static native long bmf_packet_from_videoframe(long r100);

    public static native long bmf_packet_generate_eof_packet();

    public static native long bmf_packet_generate_eos_packet();

    public static native long bmf_packet_get_json_param(long r100);

    public static native long bmf_packet_get_videoframe(long r100);

    public static native boolean bmf_packet_is_json_param(long r100);

    public static native boolean bmf_packet_is_videoframe(long r100);

    public static native void bmf_packet_set_timestamp(long r100, long r101);

    public static native long bmf_packet_timestamp(long r100);

    public static native String bmf_packet_to_json_str(long r100);

    public static native void bmf_task_fill_input_packet(long r100, int r101, long r102);

    public static native void bmf_task_fill_output_packet(long r100, int r101, long r102);

    public static native void bmf_task_free(long r100);

    public static native int[] bmf_task_get_input_stream_ids(long r100);

    public static native int[] bmf_task_get_output_stream_ids(long r100);

    public static native long bmf_task_make(int r100, int[] r101, int[] r102);

    public static native long bmf_task_pop_packet_from_input_queue(long r100, int r101);

    public static native long bmf_task_pop_packet_from_out_queue(long r100, int r101);

    public static native void bmf_task_set_timestamp(long r100, long r101);

    public static native long bmf_task_timestamp(long r100);

    public static native void bmf_vf_copy_from(long r100, long r101);

    public static native void bmf_vf_copy_props(long r100, long r101);

    public static native boolean bmf_vf_defined(long r100);

    public static native int bmf_vf_device_index(long r100);

    public static native int bmf_vf_device_type(long r100);

    public static native int bmf_vf_dtype(long r100);

    public static native long bmf_vf_frame(long r100);

    public static native void bmf_vf_free(long r100);

    public static native long bmf_vf_from_frame(long r100);

    public static native long bmf_vf_from_image(long r100);

    public static native int bmf_vf_height(long r100);

    public static native long bmf_vf_image(long r100);

    public static native boolean bmf_vf_is_image(long r100);

    public static native long bmf_vf_make_frame(int r100, int r101, long r102, String r103);

    public static native long bmf_vf_make_image(int r100, int r101, int r102, int r103, int r104, String r105, boolean r106);

    public static native void bmf_vf_private_attach_json_param(long r100, long r101);

    public static native long bmf_vf_private_get_json_param(long r100);

    public static native void bmf_vf_private_merge(long r100, long r101);

    public static native long bmf_vf_pts(long r100);

    public static native boolean bmf_vf_ready(long r100);

    public static native void bmf_vf_record(long r100, boolean r101);

    public static native void bmf_vf_set_pts(long r100, long r101);

    public static native void bmf_vf_set_time_base(long r100, int r101, int r102);

    public static native void bmf_vf_synchronize(long r100);

    public static native int[] bmf_vf_time_base(long r100);

    public static native long bmf_vf_to_device(long r100, String r101, boolean r102);

    public static native long bmf_vf_to_dtype(long r100, int r101);

    public static native long bmf_vf_to_frame(long r100, long r101);

    public static native long bmf_vf_to_image(long r100, int r101, boolean r102);

    public static native int bmf_vf_width(long r100);

    static {
        INVOKESTATIC_com_bytedance_bmf_API_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(LIBBMFMODULESDK);
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bmf_API_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
