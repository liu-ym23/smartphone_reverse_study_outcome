package com.bytedance.bmf;

import com.bytedance.hmp.ChannelFormat;
import com.bytedance.hmp.DeviceType;
import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Frame;
import com.bytedance.hmp.Image;
import com.bytedance.hmp.PixelInfo;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public class VideoFrame extends Ptr {

    /* JADX INFO: renamed from: com.bytedance.bmf.VideoFrame$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$bmf$OpaqueDataKey = null;

        static {
            int[] r100 = new int[OpaqueDataKey.values().length];
            $SwitchMap$com$bytedance$bmf$OpaqueDataKey = r100;
            r100[OpaqueDataKey.kJsonParam.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
            return;
        }
    }

    public boolean defined() {
        return API.bmf_vf_defined(this.ptr);
    }

    public int deviceIndex() {
        return API.bmf_vf_device_index(this.ptr);
    }

    public DeviceType deviceType() {
        int r100 = API.bmf_vf_device_type(this.ptr);
        DeviceType r101 = DeviceType.kCPU;
        if (r100 != 0) goto L6;
        return r101;
    L6:
        if (r100 == 1) goto L8;
        return r101;
    L8:
        return DeviceType.kCUDA;
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_vf_dtype(this.ptr)));
    }

    public Frame frame() {
        return Frame.wrap(API.bmf_vf_frame(this.ptr), false);
    }

    public void free() {
        if (this.own == false) goto L6;
        API.bmf_vf_free(this.ptr);
        return;
    }

    public int height() {
        return API.bmf_vf_height(this.ptr);
    }

    public Image image() {
        return Image.wrap(API.bmf_vf_image(this.ptr), false);
    }

    public boolean isImage() {
        return API.bmf_vf_is_image(this.ptr);
    }

    public long pts() {
        return API.bmf_vf_pts(this.ptr);
    }

    public boolean ready() {
        return API.bmf_vf_ready(this.ptr);
    }

    public void synchronize() {
        API.bmf_vf_synchronize(this.ptr);
    }

    public Rational timeBase() {
        int[] r100 = API.bmf_vf_time_base(this.ptr);
        return new Rational(r100[0], r100[1]);
    }

    public int width() {
        return API.bmf_vf_width(this.ptr);
    }

    public VideoFrame(Frame r100) {
        this.ptr = API.bmf_vf_from_frame(r100.getPtr());
        this.own = true;
    }

    public void copyFrom(VideoFrame r100) {
        API.bmf_vf_copy_from(this.ptr, r100.getPtr());
    }

    public void copyProps(VideoFrame r100) {
        API.bmf_vf_copy_props(this.ptr, r100.ptr);
    }

    public Object privateGet(OpaqueDataKey r100) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r100.ordinal()] != 1) goto L7;
        String r101 = API.bmf_json_param_dump(API.bmf_vf_private_get_json_param(this.ptr));
        return GsonProtectorUtils.fromJson(new Gson(), r101, JsonObject.class);
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateMerge(VideoFrame r100) {
        API.bmf_vf_private_merge(this.ptr, r100.ptr);
    }

    public void record(boolean r100) {
        API.bmf_vf_record(this.ptr, r100);
    }

    public void setPts(long r100) {
        API.bmf_vf_set_pts(this.ptr, r100);
    }

    public void setTimeBase(Rational r100) {
        API.bmf_vf_set_time_base(this.ptr, r100.num, r100.den);
    }

    public VideoFrame to(ScalarType r100) {
        return wrap(API.bmf_vf_to_dtype(this.ptr, r100.getValue()), true);
    }

    public VideoFrame toFrame(PixelInfo r100) {
        return wrap(API.bmf_vf_to_frame(this.ptr, r100.getPtr()), true);
    }

    public VideoFrame(Image r100) {
        this.ptr = API.bmf_vf_from_image(r100.getPtr());
        this.own = true;
    }

    public VideoFrame(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static VideoFrame wrap(long r100, boolean r101) {
        return new VideoFrame(r100, r101);
    }

    public void privateAttach(OpaqueDataKey r100, Object r101) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r100.ordinal()] != 1) goto L7;
        long r102 = API.bmf_json_param_parse(((JsonObject) r101).toString());
        API.bmf_vf_private_attach_json_param(this.ptr, r102);
        return;
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public VideoFrame to(String r100, boolean r101) {
        return wrap(API.bmf_vf_to_device(this.ptr, r100, r101), true);
    }

    public VideoFrame toImage(ChannelFormat r100, boolean r101) {
        return wrap(API.bmf_vf_to_image(this.ptr, r100.getValue(), r101), true);
    }

    public VideoFrame(int r100, int r101, PixelInfo r102, String r103) {
        this.ptr = API.bmf_vf_make_frame(r100, r101, r102.getPtr(), r103);
        this.own = true;
    }

    public VideoFrame(int r100, int r101, int r110, ChannelFormat r111, ScalarType r112, String r113, boolean r114) {
        this.ptr = API.bmf_vf_make_image(r100, r101, r110, r111.getValue(), r112.getValue(), r113, r114);
        this.own = true;
    }
}
