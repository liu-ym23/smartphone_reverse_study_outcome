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
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.contract.IAnnounceSendCallback;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
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
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.c1;
import com.ss.android.lark.widget.richtext.RichText;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public File a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ IAnnounceSendCallback d;

        public final void a() {
            tt5.a.b("sendGroupAnnouncementMsg run()", "chat id = " + this.b + "， thumbnail = " + this.c);
            Context r2 = ((k) org.koin.java.a.a(k.class)).getContext();     // Catch: Exception -> L13
            File r3 = (File) Glide.with(r2).load(new BearGlideUrl(this.c)).downloadOnly(ShareItemModel.SRC_TINT_UNDEFINED, ShareItemModel.SRC_TINT_UNDEFINED).get();     // Catch: Exception -> L10
            this.a = r3;     // Catch: Exception -> L10
            DocCallbackImpl.access$100(r3);     // Catch: Exception -> L7
            ((o) org.koin.java.a.a(o.class)).a(new e(r2, this.a.getAbsolutePath()), new UIGetDataCallback(DocCallbackImpl.access$200(r2, this.d, this.a, this.b)));     // Catch: Exception -> L13
            return;
        L7:
            e = move-exception;
            DocCallbackImpl.access$000(this.d, this.a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_2, "imageLimit file error " + e.toString());     // Catch: Exception -> L13
            return;
        L10:
            e = move-exception;
            DocCallbackImpl.access$000(this.d, this.a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_1, "glide load file error " + e.toString());     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            DocCallbackImpl.access$000(this.d, this.a, DocCallbackImpl.ANNOUNCE_SEND_SUCCESS_FAILED_3, "send Announcement fail download :" + e.toString());
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

        public a(String r1, String r2, IAnnounceSendCallback r3) {
            this.b = r1;
            this.c = r2;
            this.d = r3;
            this.a = null;
        }
    }

    static {
        sChecker = new rcc.a();
    }

    public DocCallbackImpl() {
    }

    public static /* synthetic */ File access$100(File r0) {
        return imageLimit(r0);
    }

    public static /* synthetic */ RichText access$300(o.a r0) {
        return generateRichText(r0);
    }

    private static RichText generateRichText(o.a r8) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r8.a, r0);
        String r9 = r8.b;
        int r4 = r0.outWidth;
        int r5 = r0.outHeight;
        Map r1 = RichTextElementCreator.a;
        if (r9 != null) goto L6;
        r9 = "";
    L6:
        return c.b(Collections.singletonList(RichTextElementCreator.h(RichTextElementCreator.c("", r9, r4, r5, true, null))));
    }

    private void goToMainWindow(String r4) {
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(((k) org.koin.java.a.a(k.class)).getContext(), r4, null);
    }

    private static File imageLimit(File r4) {
        Bitmap r0 = BitmapFactory.decodeFile(r4.getAbsolutePath());
        int r1 = r0.getWidth();
        int r3 = (r1 * 9) / 16;
        if (r0.getHeight() <= r3) goto L5;
        FileUtils.w(Bitmap.createBitmap(r0, 0, 0, r1, r3), r4.getAbsolutePath());
    L5:
        return r4;
    }

    private DocShareTextData parseShareTextData(Bundle r6) {
        DocShareTextData r4 = new DocShareTextData(r6.getString("android.intent.extra.TITLE", ""), r6.getString("android.intent.extra.TEXT", ""), r6.getString("android.intent.extra.USER", SHARE_FROM_DOCS), r6.getBoolean("android.intent.extra.LOCAL_ONLY", true));
        r4.setCanAddExtraInfo(r6.getBoolean(EXTRA_KEY_SUPPORT_ADDITION_NOTE, false));
        return r4;
    }

    public Bundle doCommand(Bundle r9) throws RemoteException {
        if (r9 != null) goto L6;
        new Bundle();
        tt5.a.d(TAG, "doCommand()... bundle is empty  ");
        return null;
    L6:
        String r2 = r9.getString(KEY_COMMAND);
        Context r3 = ((k) org.koin.java.a.a(k.class)).getContext();
        AppLifecycle r4 = AppLifecycle.a.a;
        Activity r5 = r4.f();
        if (n.D(r5) == false) goto L12;
        if (b.a(r4.e()) == false) goto L12;
        r5 = r4.e();
    L12:
        if (VALUE_TAB_DOCS.equals(r2) == false) goto L15;
        Bundle r1 = new Bundle();
        r1.putInt(KEY_DOC_TAB_INDEX, r9.getInt(KEY_TAB));
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(r3, "space", r1);
    L77:
        return null;
    L15:
        if (VALUE_TAB_WIKI.equals(r2) == false) goto L18;
        Bundle r6 = new Bundle();
        r6.putInt(KEY_WIKI_TAB_INDEX, r9.getInt(KEY_TAB));
        ((s) org.koin.java.a.a(s.class)).launchMainWindow(r3, FileInfoPuller.CALLER_WIKI, r6);
        goto L77
    L18:
        if (VALUE_PROFILE_MAIN.equals(r2) == false) goto L28;
        String r7 = r9.getString("user_id");
        String r8 = r9.getString("title");
        if (r5 != null) goto L22;
    L26:
        openProfile(r7, r8, r3, r9.getBoolean("isMinutes"));
        goto L77
    L22:
        if (r5.isFinishing() == true) goto L26;
        if (r5.isDestroyed() == true) goto L26;
        r3 = r5;
        goto L26
    L28:
        if (VALUE_NOTIFY_ANNOUNCEMENT_CHANGE.equals(r2) == false) goto L35;
        sendGroupAnnouncementMsg(r9.getString("chat_id"), r9.getString(KEY_THUMBNAIL), r9.getBinder("announce_send_callback"));
        int r10 = jbb.a.a;
        boolean r11 = r9.getBoolean(KEY_IS_EDITED);
        JSONObject r12 = new JSONObject();
        if (r11 == false) goto L32;
        String r13 = "y";
    L33:
        Statistics.sendEvent("announcement_notify", r12.put(KEY_IS_EDITED, r13));
        goto L77
    L32:
        r13 = "n";
        goto L33
    L35:
        if (RECOGNIZE_QR.equals(r2) == false) goto L41;
        String r14 = r9.getString(PHOTO_QR);
        if (TextUtils.isEmpty(r14) == true) goto L77;
        Bundle r0 = new Bundle();
        r0.putString(KEY_COMMAND, RECOGNIZE_QR);
        r0.putString(RESULT_QR, ((d0) org.koin.java.a.a(d0.class)).decodeQRCode(r14));
        return r0;
    L41:
        if (HANDLE_RESULT_QR.equals(r2) == false) goto L46;
        String r16 = r9.getString(RESULT_QR);
        if (TextUtils.isEmpty(r16) == true) goto L77;
        ((d0) org.koin.java.a.a(d0.class)).a(r16);
        goto L77
    L46:
        if (VALUE_MINE_ABOUT.equals(r2) == false) goto L49;
        ((s) org.koin.java.a.a(s.class)).a(r3);
        goto L77
    L49:
        if (VALUE_OPEN_EXTERNAL_URL_COMMAND.equals(r2) == false) goto L65;
        String r17 = r9.getString(VALUE_OPEN_EXTERNAL_URL);
        Serializable r18 = r9.getSerializable(VALUE_OPEN_EXTERNAL_URL_EXTRA);
        if (r18 != null) goto L53;
    L55:
        Map<String, String> r19 = null;
    L56:
        f r20 = (f) org.koin.java.a.a(f.class);
        if (r5 != null) goto L59;
    L63:
        r20.a(r3, r17, r19);
        goto L77
    L59:
        if (r5.isFinishing() == true) goto L63;
        if (r5.isDestroyed() == true) goto L63;
        r3 = r5;
        goto L63
    L53:
        if ((r18 instanceof Map) == false) goto L55;
        r19 = (Map) r18;
        goto L56
    L65:
        if (VALUE_OPEN_ISV.equals(r2) == false) goto L68;
        ((f) org.koin.java.a.a(f.class)).b(r3, r9.getString(VALUE_OPEN_EXTERNAL_URL));
        goto L77
    L68:
        if (VALUE_SHARE.equals(r2) == false) goto L71;
        goToShareForward(r5, r9);
        goto L77
    L71:
        if (VALUE_JUMP_TO_FEED.equals(r2) == false) goto L74;
        goToMainWindow(r9.getString(VALUE_PAGE_NAME, ""));
        goto L77
    L74:
        if (VALUE_CHECK_WIKI_TAB_EXIT.equals(r2) == false) goto L77;
        ((s) org.koin.java.a.a(s.class)).isEnableWikiTab();
        ((s) org.koin.java.a.a(s.class)).getTabType();
        Bundle r21 = new Bundle();
        r21.putBoolean(CustomHeaderConfig.EXIT_MENU_ID, false);
        return r21;
    }

    private void goToShareForward(Context r4, Bundle r5) {
        String r0 = r5.getString("android.intent.extra.MIME_TYPES", "");
        t r1 = (t) org.koin.java.a.a(t.class);
        if (r4 != null) goto L6;
        r4 = ((k) org.koin.java.a.a(k.class)).getContext();
    L6:
        if (TextUtils.equals(r0, "text/plain") == false) goto L9;
        r1.V0(r4, parseShareTextData(r5));
        return;
    L9:
        if (TextUtils.equals(r0, "image/*") == false) goto L11;
        r1.aa(r4, parseDocImagesForwardData(r4, r5));
        return;
    L11:
        tt5.a.h(TAG, "goToShareForward()... not support type");
    }

    private DocImagesForwardData parseDocImagesForwardData(Context r9, Bundle r10) {
        DocImagesForwardData r0 = new DocImagesForwardData();
        r0.setTitle(r10.getString("android.intent.extra.TITLE", ""));
        r0.setContent(r10.getString("android.intent.extra.TEXT", ""));
        r0.setSource(r10.getString("android.intent.extra.USER", SHARE_FROM_DOCS));
        r0.setLocalShare(r10.getBoolean("android.intent.extra.LOCAL_ONLY", false));
        ArrayList r1 = r10.getParcelableArrayList("android.intent.extra.STREAM");
        if (r1 != null) goto L5;
    L19:
        tt5.a.d(TAG, "parseDocImagesForwardData()...uris is empty");
        return r0;
    L5:
        if (CollectionUtils.isEmpty(r1) == true) goto L19;
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L17;
        String r5 = c1.c(r9, (Uri) r2.next());
        if (TextUtils.isEmpty(r5) == true) goto L9;
        if (FileUtils.p(r5).contains(IMAGE_MIME_TYPE_PREFIX) == true) goto L15;
        r4.add(r5);
        goto L9
    L15:
        r3.add(r5);
        goto L9
    L17:
        r0.setImages(r3);
        r0.setFiles(r4);
        r0.setCanAddExtraInfo(r10.getBoolean(EXTRA_KEY_SUPPORT_ADDITION_NOTE, false));
        return r0;
    }

    public void sendEvent(String r3, String r4) throws RemoteException {
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L4
    L6:
        if (r0 == null) goto L11;
        Statistics.sendEvent(r3, r0);
        return;
    L11:
        return;
    L4:
        e = move-exception;
        tt5.a.f(TAG, e, false);
        e.printStackTrace();
        r0 = null;
        goto L6
    }

    public static /* synthetic */ IGetDataCallback access$400(Context r0, IAnnounceSendCallback r1, String r2) {
        return getPostMessageDataCallback(r0, r1, r2);
    }

    public static /* synthetic */ void access$500(IAnnounceSendCallback r0, long r1, String r3) {
        notifySendFailed(r0, r1, r3);
    }

    private static IGetDataCallback<String> getPostMessageDataCallback(final Context r2, final IAnnounceSendCallback r3, final String r4) {
        tt5.a.b(TAG, "initPostMessageDataCallback");
        return new AnonymousClass3(r2, r4, r3);
    }

    private static void notifySendFailed(IAnnounceSendCallback r2, long r3, String r5) {
        r2.onAnnounceSendFailed(r3);     // Catch: RemoteException -> L5
        tt5.a.d(TAG, "sendGroupAnnouncementMsg " + r5);     // Catch: RemoteException -> L5
        return;
    L5:
        tt5.a.d(TAG, "call onAnnounceSendFailed failed");
    }

    private static void sendGroupAnnouncementMsg(String r2, String r3, IBinder r4) {
        tt5.a.b("sendGroupAnnouncementMsg ", "chat id = " + r2 + "， thumbnail = " + r3);
        CoreThreadPool.getDefault().getFixedThreadPool().execute(new a(r2, r3, IAnnounceSendCallback.Stub.asInterface(r4)));
    }

    public static /* synthetic */ void access$000(IAnnounceSendCallback r0, File r1, long r2, String r4) {
        notifySendFailed(r0, r1, r2, r4);
    }

    public static /* synthetic */ IGetDataCallback access$200(Context r0, IAnnounceSendCallback r1, File r2, String r3) {
        return getUploadEncryptDataCallback(r0, r1, r2, r3);
    }

    private static IGetDataCallback<o.a> getUploadEncryptDataCallback(final Context r2, final IAnnounceSendCallback r3, final File r4, final String r5) {
        tt5.a.b(TAG, "initUploadEncryptDataCallback");
        return new AnonymousClass2(r5, r2, r3, r4);
    }

    private static void notifySendFailed(IAnnounceSendCallback r0, File r1, long r2, String r4) {
        if (r1 == null) goto L4;
        FileUtils.g(r1.getAbsolutePath());
    L4:
        notifySendFailed(r0, r2, r4);
    }

    public static void openProfile(String r1, String r2, Context r3, boolean r4) {
        if (sChecker.a() == false) goto L6;
        tt5.a.h(TAG, "openProfile()...isDuplicate");
        return;
    L6:
        ((c0) org.koin.java.a.a(c0.class)).eb(r3, r1, r2, r4);
    }
}
