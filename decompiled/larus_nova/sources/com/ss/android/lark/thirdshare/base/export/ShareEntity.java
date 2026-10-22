package com.ss.android.lark.thirdshare.base.export;

import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.CarUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class ShareEntity implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient OnShareCallback f441195a;
    private Map<ShareActionType, String> answerTypes;
    private String appId;
    private String appPath;
    private String content;
    private String contentType;
    private File coverFile;
    private ShareActionType curActionType;
    private String downgradeContent;
    private boolean exemptEnable;
    private FileType fileType;
    private SerRunnable imageDebugRunnable;
    private ImageDowngradePanel imageDowngradePanel;
    private File imageFile;
    private Class<? extends OnShareCallback> ipcShareCallbackClass;
    private boolean isEnableChatPreview;
    private int miniProgramType;
    private ArrayList<ShareActionType> shareActionTypes;
    private ArrayList<OnShareCallback.ShareError> shareErrors;
    private String targetUrl;
    private SerRunnable textDebugRunnable;
    private TextDowngradePanel textDowngradePanel;
    private String title;
    private String traceId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentType {
        public static final String FILE = "file";
        public static final String IMAGE = "image";
        public static final String MINI_APP = "mini_app";
        public static final String TEXT = "text";
        public static final String WEB_URL = "web_url";
    }

    public static final enum FileType extends Enum<FileType> {
        public static final FileType FILE = null;
        public static final FileType IMAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FileType[] f441196a = null;

        static {
            FileType r100 = new FileType("IMAGE", 0);
            IMAGE = r100;
            FileType r101 = new FileType("FILE", 1);
            FILE = r101;
            f441196a = new FileType[]{r100, r101};
        }

        public static FileType[] values() {
            return (FileType[]) f441196a.clone();
        }

        public static FileType valueOf(String r100) {
            return (FileType) r27.a.a(FileType.class, r100);
        }

        public FileType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class ImageDowngradePanel implements Serializable {
        private String downgradePanelTitle;
        private boolean isNeedSave2Album;

        public String getDowngradePanelTitle() {
            return this.downgradePanelTitle;
        }

        public boolean isNeedSave2Album() {
            return this.isNeedSave2Album;
        }

        public ImageDowngradePanel(String r100, boolean r101) {
            this.downgradePanelTitle = r100;
            this.isNeedSave2Album = r101;
        }
    }

    public static abstract class SerRunnable implements Runnable, Serializable {
        public ShareEntity shareEntity;

        public SerRunnable(ShareEntity r100) {
            this.shareEntity = r100;
        }
    }

    public static class TextDowngradePanel implements Serializable {
        private String downgradePanelCopyContent;
        private String downgradePanelTitle;

        public String getDowngradePanelCopyContent() {
            return this.downgradePanelCopyContent;
        }

        public String getDowngradePanelTitle() {
            return this.downgradePanelTitle;
        }

        public TextDowngradePanel(String r100, String r101) {
            this.downgradePanelTitle = r100;
            this.downgradePanelCopyContent = r101;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f441197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f441198b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f441199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File f441200d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f441201e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f441202f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f441203g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f441204h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f441205i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f441206j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f441207k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public OnShareCallback f441208l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public ArrayList<ShareActionType> f441209m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Class<? extends OnShareCallback> f441210n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final ArrayList<OnShareCallback.ShareError> f441211o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public TextDowngradePanel f441212p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ImageDowngradePanel f441213q;

        public final ShareEntity a() {
            if (TextUtils.isEmpty(this.f441199c) == true) goto L6;
            ((v6c.a) ApiUtils.getApi(v6c.a.class)).a();
            Log.i("ThirdShare", "share base dep is null.");
        L6:
            if (CarUtils.a() == true) goto L8;
        L10:
            boolean r100 = false;
        L12:
            if (LarkAppContext.inst().buildConfig().isUsPackage() == true) goto L14;
            if (r100 == true) goto L14;
        L21:
            String r101 = LarkContext.getApplication().getPackageName();
            String[] r102 = {"com.ss.android.lark.inhouse", "com.larksuite.suite.inhouse"};
            int r103 = 0;
        L23:
            if (r103 >= 2) goto L28;
            if (r102[r103].equalsIgnoreCase(r101) == true) goto L26;
            r103 = r103 + 1;
            goto L23
        L26:
            boolean r104 = true;
        L29:
            if (r104 == false) goto L43;
            ArrayList r105 = new ArrayList();
            Iterator<ShareActionType> r106 = this.f441209m.iterator();
        L32:
            if (r106.hasNext() == false) goto L42;
            ShareActionType r107 = r106.next();
            String[] r108 = {"qq", "weibo"};
            int r109 = 0;
        L34:
            if (r109 >= 2) goto L39;
            if (r108[r109].equalsIgnoreCase(r107.name()) == true) goto L37;
            r109 = r109 + 1;
            goto L34
        L37:
            boolean r110 = true;
        L40:
            if (r110 == true) goto L32;
            r105.add(r107);
            goto L32
        L39:
            r110 = false;
            goto L40
        L42:
            c(r105);
        L43:
            ArrayList<ShareActionType> r111 = this.f441209m;
            ShareActionType r112 = ShareActionType.SAVE;
            if (r111.contains(r112) == true) goto L46;
        L48:
            ArrayList<ShareActionType> r113 = this.f441209m;
            ShareActionType r114 = ShareActionType.COPY;
            if (r113.contains(r114) == false) goto L56;
            if ("text".equals(this.f441198b) == true) goto L56;
            if ("web_url".equals(this.f441198b) == true) goto L56;
            OnShareCallback.ShareError r115 = OnShareCallback.ILLEGAL_CONFIG_PARAM;
            com.ss.android.lark.thirdshare.base.export.util.b.a(r115.toString("only ContentType is text or webUrl support copy."));
            this.f441211o.add(r115);
            this.f441209m.remove(r114);
        L56:
            if ("image".equals(this.f441198b) == false) goto L61;
            if (this.f441213q != null) goto L61;
            this.f441213q = new ImageDowngradePanel(UIHelper.getString(R.string.Lark_Invitation_ShareViaWeChat_ImageCreatedAndSaved), true);
        L61:
            if ("text".equals(this.f441198b) == true) goto L65;
            if ("web_url".equals(this.f441198b) == true) goto L65;
        L68:
            if (this.f441208l == null) goto L78;
            ShareActionType r116 = ShareActionType.UNKNOWN;
            if (this.f441209m.size() != 1) goto L73;
            r116 = (ShareActionType) ListProtector.get(this.f441209m, 0);
        L73:
            Iterator<OnShareCallback.ShareError> r117 = this.f441211o.iterator();
        L75:
            if (r117.hasNext() == false) goto L78;
            OnShareCallback.ShareError r118 = r117.next();
            this.f441208l.onFailed(r116, r118);
        L78:
            return new ShareEntity(this, null);
        L65:
            if (this.f441212p != null) goto L68;
            this.f441212p = new TextDowngradePanel(UIHelper.getString(R.string.Lark_Invitation_InviteViaWeChat_General_Title), this.f441202f);
            goto L68
        L46:
            if ("image".equals(this.f441198b) == true) goto L48;
            OnShareCallback.ShareError r119 = OnShareCallback.ILLEGAL_CONFIG_PARAM;
            com.ss.android.lark.thirdshare.base.export.util.b.a(r119.toString("only ContentType is image support save."));
            this.f441211o.add(r119);
            this.f441209m.remove(r112);
            goto L48
        L28:
            r104 = false;
        L14:
            ArrayList r120 = new ArrayList();
            Iterator<ShareActionType> r121 = this.f441209m.iterator();
        L16:
            if (r121.hasNext() == false) goto L20;
            ShareActionType r122 = r121.next();
            if (r122.isThirdAppShareType() == true) goto L16;
            r120.add(r122);
            goto L16
        L20:
            c(r120);
            this.f441199c = "unknown";
            goto L21
        L8:
            if (((v28.a) ClaymoreServiceLoader.loadFirst(v28.a.class)).enableThirdShare() == true) goto L10;
            r100 = true;
            goto L12
        }

        public a(VFSFile r100) {
            this.f441197a = false;
            this.f441209m = new ArrayList();
            this.f441211o = new ArrayList();
            if (r100 != null) goto L5;
        L8:
            com.ss.android.lark.thirdshare.base.export.util.b.a("imageFile is illegal");
            return;
        L5:
            if (r100.exists() == false) goto L8;
            this.f441198b = "image";
            this.f441200d = r100;
        }

        public final void b(Class r100) {
            if (OnShareCallback.class.equals(r100) == false) goto L6;
            com.ss.android.lark.thirdshare.base.export.util.b.a("shareCallbackClass is illegal");
            return;
        L6:
            this.f441210n = r100;
            this.f441208l = (OnShareCallback) r100.newInstance();     // Catch: InstantiationException -> L9 IllegalAccessException -> L11
        L14:
            if (this.f441208l != null) goto L19;
            com.ss.android.lark.thirdshare.base.export.util.b.a("ipcShareCallbackClass newInstance failed");
            return;
        L19:
            return;
        L11:
            e = move-exception;
            e.printStackTrace();
        L9:
            e = move-exception;
            e.printStackTrace();
            goto L14
        }

        public final void c(List r100) {
            if (r100 == null) goto L4;
            this.f441209m = new ArrayList(r100);
            return;
        L4:
            this.f441209m = new ArrayList();
        }

        public a(String r100) {
            this.f441197a = false;
            this.f441209m = new ArrayList();
            this.f441211o = new ArrayList();
            if (TextUtils.isEmpty(r100) == false) goto L5;
            com.ss.android.lark.thirdshare.base.export.util.b.a("content is illegal");
            return;
        L5:
            this.f441198b = "text";
            this.f441202f = r100;
            this.f441204h = r100;
        }

        public a(String r100, String r101, String r102) {
            this.f441197a = false;
            this.f441209m = new ArrayList();
            this.f441211o = new ArrayList();
            d(r100, r101, r102, r101);
        }

        public a(String r100, String r101, VFSFile r102, String r103) {
            this.f441197a = false;
            this.f441209m = new ArrayList();
            this.f441211o = new ArrayList();
            if (TextUtils.isEmpty("gh_20e9bd4e2241") == false) goto L5;
        L15:
            com.ss.android.lark.thirdshare.base.export.util.b.a("mini app share param is illegal");
            return;
        L5:
            if (TextUtils.isEmpty(r100) == true) goto L15;
            if (TextUtils.isEmpty(r101) == true) goto L15;
            if (r102 == null) goto L15;
            if (r102.exists() == false) goto L15;
            if (TextUtils.isEmpty(r103) == true) goto L15;
            this.f441205i = "gh_20e9bd4e2241";
            this.f441206j = r100;
            this.f441207k = 0;
            this.f441201e = r101;
            this.f441200d = r102;
            this.f441203g = r103;
            this.f441198b = "mini_app";
        }

        public final void d(String r100, String r101, String r102, String r103) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
        L8:
            this.f441198b = "web_url";
            this.f441201e = r100;
            this.f441202f = r101;
            this.f441203g = r102;
            this.f441204h = r103;
            return;
        L5:
            if (TextUtils.isEmpty(r102) == false) goto L8;
            com.ss.android.lark.thirdshare.base.export.util.b.a("title and targetUrl is illegal");
        }
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public b getUdSharePanelCallback() {
        return null;
    }

    public ShareActionType getCurActionType() {
        ShareActionType r100 = this.curActionType;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return ShareActionType.UNKNOWN;
    }

    public ArrayList<ShareActionType> getShareActionTypes() {
        ArrayList<ShareActionType> r100 = this.shareActionTypes;
        if (r100 != null) goto L5;
    L9:
        ArrayList<ShareActionType> r101 = new ArrayList();
        r101.add(ShareActionType.SYS);
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L9;
        return new ArrayList(this.shareActionTypes);
    }

    public String getTraceId() {
        if (TextUtils.isEmpty(this.traceId) == false) goto L7;
        return "unknown";
    L7:
        return this.traceId;
    }

    public boolean isCrossProcess() {
        if (this.ipcShareCallbackClass == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isFileShare() {
        return "file".equals(this.contentType);
    }

    public boolean isImageShare() {
        return "image".equals(this.contentType);
    }

    public boolean isMiniAppShare() {
        return "mini_app".equals(this.contentType);
    }

    public void processIpcShareCallback() {
        Class<? extends OnShareCallback> r100 = this.ipcShareCallbackClass;
        if (r100 != null) goto L18;
        Log.e("ThirdShare", "ipcShareCallbackClass is null");
        return;
    L18:
        this.f441195a = r100.newInstance();     // Catch: InstantiationException -> L8 IllegalAccessException -> L10
    L13:
        if (this.f441195a != null) goto L16;
        com.ss.android.lark.thirdshare.base.export.util.b.a("ipcShareCallbackClass newInstance failed");
        return;
    L16:
        this.ipcShareCallbackClass = null;
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public boolean isTextShare() {
        if ("text".equals(this.contentType) == false) goto L5;
    L8:
        return true;
    L5:
        if ("web_url".equals(this.contentType) == true) goto L8;
        return false;
    }

    public Map<ShareActionType, String> getAnswerTypes() {
        return this.answerTypes;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppPath() {
        return this.appPath;
    }

    public OnShareCallback getCallback() {
        return this.f441195a;
    }

    public String getContent() {
        return this.content;
    }

    public String getContentType() {
        return this.contentType;
    }

    public File getCoverFile() {
        return this.coverFile;
    }

    public String getDowngradeContent() {
        return this.downgradeContent;
    }

    public boolean getExemptEnable() {
        return this.exemptEnable;
    }

    public FileType getFileType() {
        return this.fileType;
    }

    public Runnable getImageDebugRunnable() {
        return this.imageDebugRunnable;
    }

    public ImageDowngradePanel getImageDowngradePanel() {
        return this.imageDowngradePanel;
    }

    public File getImageFile() {
        return this.imageFile;
    }

    public int getMiniProgramType() {
        return this.miniProgramType;
    }

    public String getTargetUrl() {
        return this.targetUrl;
    }

    public Runnable getTextDebugRunnable() {
        return this.textDebugRunnable;
    }

    public TextDowngradePanel getTextDowngradePanel() {
        return this.textDowngradePanel;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isEnableChatPreview() {
        return this.isEnableChatPreview;
    }

    public void setCallback(final OnShareCallback r100) {
        this.f441195a = new AnonymousClass1(this, r100);
    }

    public void setCurActionType(ShareActionType r100) {
        this.curActionType = r100;
    }

    public void setImageDebugRunnable(SerRunnable r100) {
        this.imageDebugRunnable = r100;
    }

    public void setTextDebugRunnable(SerRunnable r100) {
        this.textDebugRunnable = r100;
    }

    public ShareEntity(a r100, AnonymousClass1 r101) {
        this.exemptEnable = r100.f441197a;
        this.traceId = r100.f441199c;
        this.contentType = r100.f441198b;
        this.imageFile = r100.f441200d;
        this.fileType = null;
        this.title = r100.f441201e;
        this.content = r100.f441202f;
        this.targetUrl = r100.f441203g;
        this.downgradeContent = r100.f441204h;
        r100.getClass();
        this.coverFile = null;
        this.appId = r100.f441205i;
        this.appPath = r100.f441206j;
        this.miniProgramType = r100.f441207k;
        setCallback(r100.f441208l);
        this.shareActionTypes = r100.f441209m;
        this.ipcShareCallbackClass = r100.f441210n;
        this.answerTypes = null;
        this.shareErrors = r100.f441211o;
        this.textDowngradePanel = r100.f441212p;
        this.imageDowngradePanel = r100.f441213q;
        this.isEnableChatPreview = false;
    }
}
