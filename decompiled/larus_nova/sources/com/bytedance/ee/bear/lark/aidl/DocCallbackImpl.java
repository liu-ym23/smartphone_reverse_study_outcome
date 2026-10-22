package com.bytedance.ee.bear.lark.aidl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bytedance.ee.bear.contract.IAnnounceSendCallback;
import com.bytedance.ee.bear.dto.DocImagesForwardData;
import com.bytedance.ee.bear.dto.DocShareTextData;
import com.bytedance.ee.bear.lark.dependency.c0;
import com.bytedance.ee.bear.lark.dependency.d0;
import com.bytedance.ee.bear.lark.dependency.f;
import com.bytedance.ee.bear.lark.dependency.k;
import com.bytedance.ee.bear.lark.dependency.o;
import com.bytedance.ee.bear.lark.dependency.s;
import com.bytedance.ee.bear.lark.dependency.t;
import com.bytedance.ee.util.glide.BearGlideUrl;
import com.bytedance.ee.util.ui.b;
import com.bytedance.ee.util.ui.n;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.larksuite.framework.utils.FileUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.doc.IDocCallback;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import com.ss.android.lark.widget.richtext.RichTextElementCreator;
import com.ss.android.lark.widget.richtext.c;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import wb5.e;

/* JADX INFO: loaded from: classes16.dex */
public class DocCallbackImpl extends IDocCallback.Stub {
    private static final long ANNOUNCE_SEND_SUCCESS_FAILED_1 = 40020211201L;
    private static final long ANNOUNCE_SEND_SUCCESS_FAILED_10 = 40020211210L;
    private static final long ANNOUNCE_SEND_SUCCESS_FAILED_2 = 40020211202L;
    private static final long ANNOUNCE_SEND_SUCCESS_FAILED_3 = 40020211203L;
    private static final long ANNOUNCE_SEND_SUCCESS_FAILED_8 = 40020211208L;
    public static final int CONTACT_FROM_TYPE_COMMON_CONTACT = 0;
    public static final int CONTACT_FROM_TYPE_NEW_CONTACT = 2;
    private static final String EXTRA_KEY_SUPPORT_ADDITION_NOTE = "support_addition_note";
    private static final String HANDLE_RESULT_QR = "handle_result_qr";
    private static final String IMAGE_MIME_TYPE_PREFIX = "image/";
    public static final String KEY_CHAT_ID = "chat_id";
    private static final String KEY_COMMAND = "command";
    public static final String KEY_CONTACT_FROM_TYPE = "contact_from_type";
    public static final String KEY_CONTACT_INFO = "contact_info";
    public static final String KEY_DOC_TAB_INDEX = "key_doc_tab_index";
    public static final String KEY_IS_EDITED = "is_edited";
    private static final String KEY_TAB = "tab";
    private static final String KEY_TAB_NAME = "tab_name";
    public static final String KEY_THUMBNAIL = "thumbnail";
    public static final String KEY_WIKI_TAB_INDEX = "key_wiki_tab_index";
    private static final String PHOTO_QR = "photo_qr";
    private static final String RECOGNIZE_QR = "recognize_qr";
    private static final String RESULT_QR = "result_qr";
    private static final String SHARE_FROM_DOCS = "Docs";
    public static final String TAG = "DocCallbackImpl";
    private static final String VALUE_CHECK_WIKI_TAB_EXIT = "check_wiki_tab_exit";
    private static final String VALUE_JUMP_TO_FEED = "jump_to_feed";
    private static final String VALUE_MINE_ABOUT = "mine_about";
    private static final String VALUE_NOTIFY_ANNOUNCEMENT_CHANGE = "notify_announcement_change";
    private static final String VALUE_OPEN_EXTERNAL_URL = "url";
    private static final String VALUE_OPEN_EXTERNAL_URL_COMMAND = "open_url";
    private static final String VALUE_OPEN_EXTERNAL_URL_EXTRA = "extra";
    private static final String VALUE_OPEN_ISV = "open_isv";
    private static final String VALUE_PAGE_NAME = "page_name";
    private static final String VALUE_PROFILE_MAIN = "profile_main";
    private static final String VALUE_SHARE = "share";
    private static final String VALUE_TAB_DOCS = "tab_docs";
    private static final String VALUE_TAB_WIKI = "tab_wiki";
    private static rcc.a sChecker;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f227211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f227212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f227213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ IAnnounceSendCallback f227214d;

        public final void a() {
            tt5.a.b("sendGroupAnnouncementMsg run()", "chat id = " + this.f227212b + "， thumbnail = " + this.f227213c);
            Context r100 = ((k) org.koin.java.a.a(k.class)).getContext();     // Catch: Exception -> L13
            File r101 = Glide.with(r100).load(new BearGlideUrl(this.f227213c)).downloadOnly(Integer.MIN_VALUE, Integer.MIN_VALUE).get();     // Catch: Exception -> L10
            this.f227211a = r101;     // Catch: Exception -> L10
            DocCallbackImpl.access$100(r101);     // Catch: Exception -> L7
            ((o) org.koin.java.a.a(o.class)).a(new e(r100, this.f227211a.getAbsolutePath()), new UIGetDataCallback(DocCallbackImpl.access$200(r100, this.f227214d, this.f227211a, this.f227212b)));     // Catch: Exception -> L13
            return;
        L7:
            e = move-exception;
            DocCallbackImpl.access$000(this.f227214d, this.f227211a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_2, "imageLimit file error " + e.toString());     // Catch: Exception -> L13
            return;
        L10:
            e = move-exception;
            DocCallbackImpl.access$000(this.f227214d, this.f227211a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_1, "glide load file error " + e.toString());     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            DocCallbackImpl.access$000(this.f227214d, this.f227211a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_3, "send Announcement fail download :" + e.toString());
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, String r101, IAnnounceSendCallback r102) {
            this.f227212b = r100;
            this.f227213c = r101;
            this.f227214d = r102;
            this.f227211a = null;
        }
    }

    static {
        sChecker = new rcc.a();
    }

    public DocCallbackImpl() {
    }

    public static /* synthetic */ File access$100(File r100) {
        return imageLimit(r100);
    }

    public static /* synthetic */ RichText access$300(o.a r100) {
        return generateRichText(r100);
    }

    private static RichText generateRichText(o.a r100) {
        BitmapFactory.Options r101 = new BitmapFactory.Options();
        r101.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r100.f227357a, r101);
        String r102 = r100.f227358b;
        int r103 = r101.outWidth;
        int r104 = r101.outHeight;
        Map<Class<? extends RichTextElement.RichTextProperty>, RichTextElement.RichTextTag> r105 = RichTextElementCreator.f448209a;
        if (r102 != null) goto L6;
        r102 = "";
    L6:
        return c.b(Collections.singletonList(RichTextElementCreator.h(RichTextElementCreator.c("", r102, r103, r104, true, null))));
    }

    private void goToMainWindow(String r100) {
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(((k) org.koin.java.a.a(k.class)).getContext(), r100, null);
    }

    private static File imageLimit(File r100) {
        Bitmap r101 = BitmapFactory.decodeFile(r100.getAbsolutePath());
        int r102 = r101.getWidth();
        int r103 = (r102 * 9) / 16;
        if (r101.getHeight() <= r103) goto L5;
        FileUtils.w(Bitmap.createBitmap(r101, 0, 0, r102, r103), r100.getAbsolutePath());
    L5:
        return r100;
    }

    private DocShareTextData parseShareTextData(Bundle r100) {
        DocShareTextData r101 = new DocShareTextData(r100.getString("android.intent.extra.TITLE", ""), r100.getString("android.intent.extra.TEXT", ""), r100.getString("android.intent.extra.USER", SHARE_FROM_DOCS), r100.getBoolean("android.intent.extra.LOCAL_ONLY", true));
        r101.setCanAddExtraInfo(r100.getBoolean(EXTRA_KEY_SUPPORT_ADDITION_NOTE, false));
        return r101;
    }

    @Override // com.ss.android.lark.doc.IDocCallback
    public Bundle doCommand(Bundle r100) throws RemoteException {
        if (r100 != null) goto L6;
        new Bundle();
        tt5.a.d(TAG, "doCommand()... bundle is empty  ");
        return null;
    L6:
        String r101 = r100.getString("command");
        Context r102 = ((k) org.koin.java.a.a(k.class)).getContext();
        AppLifecycle r103 = AppLifecycle.a.f408803a;
        Activity r104 = r103.f();
        if (n.D(r104) == false) goto L12;
        if (b.a(r103.e()) == false) goto L12;
        r104 = r103.e();
    L12:
        if (VALUE_TAB_DOCS.equals(r101) == false) goto L15;
        Bundle r105 = new Bundle();
        r105.putInt(KEY_DOC_TAB_INDEX, r100.getInt("tab"));
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(r102, "space", r105);
    L77:
        return null;
    L15:
        if (VALUE_TAB_WIKI.equals(r101) == false) goto L18;
        Bundle r106 = new Bundle();
        r106.putInt(KEY_WIKI_TAB_INDEX, r100.getInt("tab"));
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(r102, "wiki", r106);
        goto L77
    L18:
        if (VALUE_PROFILE_MAIN.equals(r101) == false) goto L28;
        String r107 = r100.getString("user_id");
        String r108 = r100.getString("title");
        if (r104 != null) goto L22;
    L26:
        openProfile(r107, r108, r102, r100.getBoolean("isMinutes"));
        goto L77
    L22:
        if (r104.isFinishing() == true) goto L26;
        if (r104.isDestroyed() == true) goto L26;
        r102 = r104;
        goto L26
    L28:
        if (VALUE_NOTIFY_ANNOUNCEMENT_CHANGE.equals(r101) == false) goto L35;
        sendGroupAnnouncementMsg(r100.getString("chat_id"), r100.getString(KEY_THUMBNAIL), r100.getBinder("announce_send_callback"));
        int r109 = jbb.a.f498063a;
        boolean r110 = r100.getBoolean(KEY_IS_EDITED);
        JSONObject r111 = new JSONObject();
        if (r110 == false) goto L32;
        String r112 = "y";
    L33:
        Statistics.sendEvent("announcement_notify", r111.put(KEY_IS_EDITED, r112));
        goto L77
    L32:
        r112 = OfficeSDKRequestTag.KEY_NEW_USER;
        goto L33
    L35:
        if (RECOGNIZE_QR.equals(r101) == false) goto L41;
        String r113 = r100.getString(PHOTO_QR);
        if (TextUtils.isEmpty(r113) == true) goto L77;
        Bundle r114 = new Bundle();
        r114.putString("command", RECOGNIZE_QR);
        r114.putString(RESULT_QR, ((d0) org.koin.java.a.a(d0.class)).decodeQRCode(r113));
        return r114;
    L41:
        if (HANDLE_RESULT_QR.equals(r101) == false) goto L46;
        String r115 = r100.getString(RESULT_QR);
        if (TextUtils.isEmpty(r115) == true) goto L77;
        ((d0) org.koin.java.a.a(d0.class)).a(r115);
        goto L77
    L46:
        if (VALUE_MINE_ABOUT.equals(r101) == false) goto L49;
        ((s) org.koin.java.a.a(s.class)).a(r102);
        goto L77
    L49:
        if ("open_url".equals(r101) == false) goto L65;
        String r116 = r100.getString("url");
        Serializable r117 = r100.getSerializable("extra");
        if (r117 != null) goto L53;
    L55:
        Map<String, String> r118 = null;
    L56:
        f r119 = (f) org.koin.java.a.a(f.class);
        if (r104 != null) goto L59;
    L63:
        r119.a(r102, r116, r118);
        goto L77
    L59:
        if (r104.isFinishing() == true) goto L63;
        if (r104.isDestroyed() == true) goto L63;
        r102 = r104;
        goto L63
    L53:
        if ((r117 instanceof Map) == false) goto L55;
        r118 = (Map) r117;
        goto L56
    L65:
        if (VALUE_OPEN_ISV.equals(r101) == false) goto L68;
        ((f) org.koin.java.a.a(f.class)).b(r102, r100.getString("url"));
        goto L77
    L68:
        if ("share".equals(r101) == false) goto L71;
        goToShareForward(r104, r100);
        goto L77
    L71:
        if (VALUE_JUMP_TO_FEED.equals(r101) == false) goto L74;
        goToMainWindow(r100.getString("page_name", ""));
        goto L77
    L74:
        if (VALUE_CHECK_WIKI_TAB_EXIT.equals(r101) == false) goto L77;
        ((s) org.koin.java.a.a(s.class)).isEnableWikiTab();
        ((s) org.koin.java.a.a(s.class)).getTabType();
        Bundle r120 = new Bundle();
        r120.putBoolean("exit", false);
        return r120;
    }

    private void goToShareForward(Context r100, Bundle r101) {
        String r102 = r101.getString("android.intent.extra.MIME_TYPES", "");
        t r103 = (t) org.koin.java.a.a(t.class);
        if (r100 != null) goto L6;
        r100 = ((k) org.koin.java.a.a(k.class)).getContext();
    L6:
        if (TextUtils.equals(r102, "text/plain") == false) goto L9;
        r103.V0(r100, parseShareTextData(r101));
        return;
    L9:
        if (TextUtils.equals(r102, "image/*") == false) goto L11;
        r103.aa(r100, parseDocImagesForwardData(r100, r101));
        return;
    L11:
        tt5.a.h(TAG, "goToShareForward()... not support type");
    }

    private DocImagesForwardData parseDocImagesForwardData(Context r100, Bundle r110) {
        DocImagesForwardData r101 = new DocImagesForwardData();
        r101.setTitle(r110.getString("android.intent.extra.TITLE", ""));
        r101.setContent(r110.getString("android.intent.extra.TEXT", ""));
        r101.setSource(r110.getString("android.intent.extra.USER", SHARE_FROM_DOCS));
        r101.setLocalShare(r110.getBoolean("android.intent.extra.LOCAL_ONLY", false));
        ArrayList r102 = r110.getParcelableArrayList("android.intent.extra.STREAM");
        if (r102 != null) goto L5;
    L19:
        tt5.a.d(TAG, "parseDocImagesForwardData()...uris is empty");
        return r101;
    L5:
        if (CollectionUtils.isEmpty(r102) == true) goto L19;
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L17;
        String r106 = c1.c(r100, (Uri) r105.next());
        if (TextUtils.isEmpty(r106) == true) goto L9;
        if (FileUtils.p(r106).contains(IMAGE_MIME_TYPE_PREFIX) == true) goto L15;
        r104.add(r106);
        goto L9
    L15:
        r103.add(r106);
        goto L9
    L17:
        r101.setImages(r103);
        r101.setFiles(r104);
        r101.setCanAddExtraInfo(r110.getBoolean(EXTRA_KEY_SUPPORT_ADDITION_NOTE, false));
        return r101;
    }

    @Override // com.ss.android.lark.doc.IDocCallback
    public void sendEvent(String r100, String r101) throws RemoteException {
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L4
    L6:
        if (r102 == null) goto L11;
        Statistics.sendEvent(r100, r102);
        return;
    L11:
        return;
    L4:
        e = move-exception;
        tt5.a.f(TAG, e, false);
        e.printStackTrace();
        r102 = null;
        goto L6
    }

    public static /* synthetic */ IGetDataCallback access$400(Context r100, IAnnounceSendCallback r101, String r102) {
        return getPostMessageDataCallback(r100, r101, r102);
    }

    public static /* synthetic */ void access$500(IAnnounceSendCallback r100, long r101, String r102) {
        notifySendFailed(r100, r101, r102);
    }

    private static IGetDataCallback<String> getPostMessageDataCallback(final Context r100, final IAnnounceSendCallback r101, final String r102) {
        tt5.a.b(TAG, "initPostMessageDataCallback");
        return new AnonymousClass3(r100, r102, r101);
    }

    private static void notifySendFailed(IAnnounceSendCallback r100, long r101, String r102) {
        r100.onAnnounceSendFailed(r101);     // Catch: RemoteException -> L5
        tt5.a.d(TAG, "sendGroupAnnouncementMsg " + r102);     // Catch: RemoteException -> L5
        return;
    L5:
        tt5.a.d(TAG, "call onAnnounceSendFailed failed");
    }

    private static void sendGroupAnnouncementMsg(String r100, String r101, IBinder r102) {
        tt5.a.b("sendGroupAnnouncementMsg ", "chat id = " + r100 + "， thumbnail = " + r101);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r100, r101, IAnnounceSendCallback.Stub.asInterface(r102)));
    }

    public static /* synthetic */ void access$000(IAnnounceSendCallback r100, File r101, long r102, String r103) {
        notifySendFailed(r100, r101, r102, r103);
    }

    public static /* synthetic */ IGetDataCallback access$200(Context r100, IAnnounceSendCallback r101, File r102, String r103) {
        return getUploadEncryptDataCallback(r100, r101, r102, r103);
    }

    private static IGetDataCallback<o.a> getUploadEncryptDataCallback(final Context r100, final IAnnounceSendCallback r101, final File r102, final String r103) {
        tt5.a.b(TAG, "initUploadEncryptDataCallback");
        return new AnonymousClass2(r103, r100, r101, r102);
    }

    private static void notifySendFailed(IAnnounceSendCallback r100, File r101, long r102, String r103) {
        if (r101 == null) goto L4;
        FileUtils.g(r101.getAbsolutePath());
    L4:
        notifySendFailed(r100, r102, r103);
    }

    public static void openProfile(String r100, String r101, Context r102, boolean r103) {
        if (sChecker.a() == false) goto L6;
        tt5.a.h(TAG, "openProfile()...isDuplicate");
        return;
    L6:
        ((c0) org.koin.java.a.a(c0.class)).eb(r102, r100, r101, r103);
    }
}
