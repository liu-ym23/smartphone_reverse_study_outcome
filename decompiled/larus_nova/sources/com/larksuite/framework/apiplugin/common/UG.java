package com.larksuite.framework.apiplugin.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParam;
import com.larksuite.framework.apiplugin.annotation.LKRequiredParamContainer;
import com.larksuite.framework.apiplugin.validator.format.GrayKey;
import com.larksuite.framework.apiplugin.validator.format.NotBlank;
import com.larksuite.framework.apiplugin.validator.format.StringEnum;
import com.larus.media.MediaScene;
import com.ss.android.lark.camera_export.CameraParam;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final class UG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f285508a = null;

    public static final enum ShareChannelType extends Enum<ShareChannelType> {
        public static final ShareChannelType SYSTEM = null;
        public static final ShareChannelType WX = null;
        public static final ShareChannelType WX_TIMELINE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareChannelType[] f285509a = null;
        public String mValue;

        static {
            ShareChannelType r100 = new ShareChannelType("WX", 0, "wx");
            WX = r100;
            ShareChannelType r101 = new ShareChannelType("WX_TIMELINE", 1, "wx_timeline");
            WX_TIMELINE = r101;
            ShareChannelType r102 = new ShareChannelType(MediaScene.SYSTEM, 2, CameraParam.TYPE_SYSTEM_CAMERA);
            SYSTEM = r102;
            f285509a = new ShareChannelType[]{r100, r101, r102};
        }

        public static ShareChannelType[] values() {
            return (ShareChannelType[]) f285509a.clone();
        }

        public static ShareChannelType valueOf(String r100) {
            return (ShareChannelType) a.a(ShareChannelType.class, r100);
        }

        public ShareChannelType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static final enum ShareContentType extends Enum<ShareContentType> {
        public static final ShareContentType FILE = null;
        public static final ShareContentType IMAGE = null;
        public static final ShareContentType TEXT = null;
        public static final ShareContentType WEB_URL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ShareContentType[] f285510a = null;
        public final String mValue;

        static {
            ShareContentType r100 = new ShareContentType(CardAdapter.TEXT, 0, "text");
            TEXT = r100;
            ShareContentType r101 = new ShareContentType("IMAGE", 1, "image");
            IMAGE = r101;
            ShareContentType r102 = new ShareContentType("WEB_URL", 2, "url");
            WEB_URL = r102;
            ShareContentType r103 = new ShareContentType("FILE", 3, "file");
            FILE = r103;
            f285510a = new ShareContentType[]{r100, r101, r102, r103};
        }

        public static ShareContentType[] values() {
            return (ShareContentType[]) f285510a.clone();
        }

        public static ShareContentType valueOf(String r100) {
            return (ShareContentType) a.a(ShareContentType.class, r100);
        }

        public ShareContentType(String r100, int r101, String r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public static class ShareRequest extends LKBaseRequestModel {

        @GrayKey("feature_key_share")
        @StringEnum(gray = true, values = {"wx", "wx_timeline", CameraParam.TYPE_SYSTEM_CAMERA})
        @NotBlank(gray = true)
        @JSONField(name = "channelType")
        public List<String> mChannelType;

        @JSONField(name = "content")
        public String mContent;

        @GrayKey("feature_key_share")
        @StringEnum(gray = true, values = {"text", "image", "url", "file"})
        @LKRequiredParamContainer({@LKRequiredParam, @LKRequiredParam(gray = true)})
        @JSONField(name = "contentType")
        public String mContentType;

        @JSONField(name = "filePath")
        public String mFilePath;

        @JSONField(name = "image")
        public String mImage;

        @JSONField(name = "title")
        public String mTitle;

        @JSONField(name = "url")
        public String mUrl;

        public ShareRequest() {
            this.mChannelType = new ArrayList(UG.f285508a);
        }
    }

    public static class ShareResponse extends LKBaseResponseModel {
        public ShareResponse() {
        }
    }

    static {
        f285508a = new ArrayList();
        if (LarkContext.getApplication().getPackageName().contains("com.larksuite.suite") == false) goto L5;
        f285508a = new ArrayList(Arrays.asList(new String[]{ShareChannelType.SYSTEM.mValue}));
        return;
    L5:
        f285508a = new ArrayList(Arrays.asList(new String[]{ShareChannelType.WX.mValue, ShareChannelType.WX_TIMELINE.mValue}));
    }
}
