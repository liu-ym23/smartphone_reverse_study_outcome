package com.bytedance.bmf;

import com.bytedance.hmp.EnumUtil;
import com.bytedance.hmp.Ptr;
import com.bytedance.hmp.ScalarType;
import com.bytedance.hmp.Tensor;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes43.dex */
public class AudioFrame extends Ptr {

    /* JADX INFO: renamed from: com.bytedance.bmf.AudioFrame$1, reason: invalid class name */
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
        return API.bmf_af_defined(this.ptr);
    }

    public ScalarType dtype() {
        return (ScalarType) EnumUtil.fromValue(ScalarType.class, Integer.valueOf(API.bmf_af_dtype(this.ptr)));
    }

    public void free() {
        if (this.own == false) goto L6;
        API.bmf_af_free(this.ptr);
        return;
    }

    public int nchannels() {
        return API.bmf_af_nchannels(this.ptr);
    }

    public int nplanes() {
        return API.bmf_af_nplanes(this.ptr);
    }

    public int nsamples() {
        return API.bmf_af_nsamples(this.ptr);
    }

    public boolean planer() {
        return API.bmf_af_planer(this.ptr);
    }

    public Tensor[] planes() {
        long[] r100 = API.bmf_af_planes(this.ptr);
        int r101 = r100.length;
        Tensor[] r102 = new Tensor[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = Tensor.wrap(r100[r103], true);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public long pts() {
        return API.bmf_af_pts(this.ptr);
    }

    public float sampleRate() {
        return API.bmf_af_sample_rate(this.ptr);
    }

    public Rational timeBase() {
        int[] r100 = API.bmf_af_time_base(this.ptr);
        return new Rational(r100[0], r100[1]);
    }

    public void copyProps(AudioFrame r100) {
        API.bmf_af_copy_props(this.ptr, r100.ptr);
    }

    public Tensor plane(int r100) {
        return Tensor.wrap(API.bmf_af_plane(this.ptr, r100), true);
    }

    public Object privateGet(OpaqueDataKey r100) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r100.ordinal()] != 1) goto L7;
        String r101 = API.bmf_json_param_dump(API.bmf_af_private_get_json_param(this.ptr));
        return GsonProtectorUtils.fromJson(new Gson(), r101, JsonObject.class);
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateGet");
    }

    public void privateMerge(AudioFrame r100) {
        API.bmf_af_private_merge(this.ptr, r100.ptr);
    }

    public void setPts(long r100) {
        API.bmf_af_set_pts(this.ptr, r100);
    }

    public void setSampleRate(float r100) {
        API.bmf_af_set_sample_rate(this.ptr, r100);
    }

    public void setTimeBase(Rational r100) {
        API.bmf_af_set_time_base(this.ptr, r100.num, r100.den);
    }

    public AudioFrame(long r100, boolean r101) {
        this.ptr = r100;
        this.own = r101;
    }

    public static AudioFrame wrap(long r100, boolean r101) {
        return new AudioFrame(r100, r101);
    }

    public void privateAttach(OpaqueDataKey r100, Object r101) throws IllegalArgumentException {
        if (AnonymousClass1.$SwitchMap$com$bytedance$bmf$OpaqueDataKey[r100.ordinal()] != 1) goto L7;
        long r102 = API.bmf_json_param_parse(((JsonObject) r101).toString());
        API.bmf_af_private_attach_json_param(this.ptr, r102);
        return;
    L7:
        throw new IllegalArgumentException("Unknown opaque data key in PrivateAttach");
    }

    public AudioFrame(Tensor[] r100, int r101, int r102, boolean r103) {
        int r104 = r100.length;
        long[] r105 = new long[r104];
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L5;
        r105[r106] = r100[r106].getPtr();
        r106 = r106 + 1;
        goto L3
    L5:
        this.ptr = API.bmf_af_make_from_data(r105, r101, r102, r103);
        this.own = true;
    }

    public AudioFrame(int r100, int r101, boolean r102, ScalarType r103) {
        this.ptr = API.bmf_af_make(r100, r101, r102, r103.getValue());
        this.own = true;
    }
}
