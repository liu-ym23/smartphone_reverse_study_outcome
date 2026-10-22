package com.ss.android.lark.image.impl.avatar;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.image.entity.AvatarImage;
import com.ss.android.lark.utils.UIHelper;
import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes36.dex */
public class AvatarImageNameManager {
    private static String BIG_SIZE_SUFFIX = "_hd";
    private static String DEFAULT_AVATER_PREFIX = "default-avatar_";
    private static String MID_SIZE_SUFFIX = "_mid";
    private static String SMALL_SIZE_SUFFIX = "_th";
    private LruCache<String, String> mMd5NameCache;
    private List<String> mSpecialEntityId;
    private int[][] mSuffixSizeConfig;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.avatar.AvatarImageNameManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class HOLDER {
        private static final AvatarImageNameManager INSTANCE = null;

        static {
            INSTANCE = new AvatarImageNameManager(null);
        }

        public static /* synthetic */ AvatarImageNameManager access$000() {
            return INSTANCE;
        }
    }

    private int getDensityIndex(float r100) {
        if (r100 > 1.0f) goto L7;
        return 0;
    L7:
        if (r100 > 2.0f) goto L10;
        return 1;
    L10:
        return 2;
    }

    private AvatarImageNameManager() {
        Class r100 = Integer.TYPE;
        this.mSuffixSizeConfig = (int[][]) Array.newInstance(r100, new int[]{3, 2});
        this.mMd5NameCache = new LruCache(100);
        ArrayList r101 = new ArrayList();
        this.mSpecialEntityId = r101;
        int[][] r102 = this.mSuffixSizeConfig;
        int[] r103 = r102[0];
        r103[0] = 32;
        r103[1] = 79;
        int[] r104 = r102[1];
        r104[0] = 32;
        r104[1] = 79;
        int[] r105 = r102[2];
        r105[0] = 32;
        r105[1] = 79;
        r101.add("1");
        this.mSpecialEntityId.add("2");
    }

    public static final AvatarImageNameManager inst() {
        return HOLDER.access$000();
    }

    public /* synthetic */ AvatarImageNameManager(AnonymousClass1 r100) {
        this();
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageNameManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private String generatePrefix(AvatarImage r100) {
        long r101 = r100.getEntityId();
        String r102 = r100.getEntityIdStr();
        String r103 = r100.getKey();
        if (r101 != 0) goto L5;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == false) goto L15;
        return r103;
    L15:
        return getEncryptEntityId(r100.getEntityIdStr());
    L5:
        if (this.mSpecialEntityId.contains(r102) == true) goto L11;
        if (r103 != null) goto L8;
    L10:
        r104 = false;
        goto L12
    L8:
        if (r103.startsWith(DEFAULT_AVATER_PREFIX) == false) goto L10;
        goto L10
    }

    private String getEncryptEntityId(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return DEFAULT_AVATER_PREFIX;
    L7:
        if (this.mMd5NameCache.contains(r100) == true) goto L9;
        String r101 = Util.md5BytesToHex(MessageDigest.getInstance("MD5").digest(r100.getBytes()));     // Catch: NoSuchAlgorithmException -> L12
        this.mMd5NameCache.put(r100, r101);     // Catch: NoSuchAlgorithmException -> L12
        return r101;
    L12:
        e = move-exception;
        e.printStackTrace();
        return DEFAULT_AVATER_PREFIX;
    L9:
        return this.mMd5NameCache.get(r100);
    }

    private String generateSuffix(Context r100, AvatarImage r101) {
        float r102 = INVOKEVIRTUAL_com_ss_android_lark_image_impl_avatar_AvatarImageNameManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density;
        int r103 = UIHelper.px2dp(Math.max(r101.getWidth(), r101.getHeight()));
        int[] r104 = this.mSuffixSizeConfig[getDensityIndex(r102)];
        if (r103 > r104[0]) goto L7;
        return SMALL_SIZE_SUFFIX;
    L7:
        if (r103 > r104[1]) goto L11;
        return MID_SIZE_SUFFIX;
    L11:
        return BIG_SIZE_SUFFIX;
    }

    public String generateFileName(Context r100, AvatarImage r101) {
        return generatePrefix(r101) + generateSuffix(r100, r101);
    }
}
