package com.bytedance.ee.bear.doc.toolbar;

import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.toolbar2.BaseToolbarV2Plugin;
import oz4.c;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SlideHideKeyboardPlugin extends DocumentPlugin implements View.OnTouchListener {
    private static final String SHEET_PANEL_NAME = "sheet_editor";
    private static final String TAG = "SlideHideKeyboardPlugin";
    private GestureDetector gestureDetector;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ DocumentPluginHost a;
        public final /* synthetic */ SlideHideKeyboardPlugin b;

        public a(SlideHideKeyboardPlugin r1, DocumentPluginHost r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r1, MotionEvent r2, float r3, float r4) {
            if (r4 > 0.0f) goto L5;
            return false;
        L5:
            if (SlideHideKeyboardPlugin.access$000(this.b) == true) goto L8;
            tt5.a.h(SlideHideKeyboardPlugin.TAG, "is sheet edit, not hide keyboard");
            return false;
        L8:
            tt5.a.h(SlideHideKeyboardPlugin.TAG, "is not sheet edit, hide keyboard");
            this.a.findPluginToDo(BaseToolbarV2Plugin.class, new c(this));
            rcb.c.d(SlideHideKeyboardPlugin.access$100(this.b).getWebView());
            return true;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean isNeedHideKeyboard() {
        if (getHost() != 0) goto L5;
    L13:
        return true;
    L5:
        if (((DocumentPluginHost) getHost()).b() == null) goto L13;
        if (((DocumentPluginHost) getHost()).b().getActiveEditPanel() == null) goto L13;
        if (((DocumentPluginHost) getHost()).b().getActiveEditPanel().getValue() == null) goto L13;
        tt5.a.h(TAG, "active edit panel name:" + ((g45.a) ((DocumentPluginHost) getHost()).b().getActiveEditPanel().getValue()).getPanelName());
        return !TextUtils.equals(((g45.a) ((DocumentPluginHost) getHost()).b().getActiveEditPanel().getValue()).getPanelName(), SHEET_PANEL_NAME);
    }

    public SlideHideKeyboardPlugin() {
    }

    public static /* synthetic */ boolean access$000(SlideHideKeyboardPlugin r0) {
        return r0.isNeedHideKeyboard();
    }

    public static /* synthetic */ k access$100(SlideHideKeyboardPlugin r0) {
        return r0.getWeb();
    }

    public static /* synthetic */ FragmentActivity access$200(SlideHideKeyboardPlugin r0) {
        return r0.getActivity();
    }

    public void onAttachToUIContainer(DocumentPluginHost r3, t r4) {
        super.onAttachToUIContainer(r3, r4);
        this.gestureDetector = new GestureDetector(getContext(), new a(this, r3));
        getWeb().addOnTouchListener(this);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        getWeb().removeOnTouchListener(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        this.gestureDetector.onTouchEvent(r2);
        return false;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
