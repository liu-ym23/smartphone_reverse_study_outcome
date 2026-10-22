package com.dtf.face.ui.overlay;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import js7.b;

/* JADX INFO: loaded from: classes22.dex */
public class CommAlertOverlay extends FrameLayout {
    public CommAlertOverlayListener commAlertOverlayListener;
    private boolean hasCancel;

    public interface CommAlertOverlayListener {
        void onCancel();

        void onConfirm();
    }

    public int getLayoutID() {
        return R.layout.dtf_comm_alert_layout;
    }

    public void setBackgroundShadowAlpha(float r100) {
        if (r100 >= 0.0f) goto L5;
        return;
    L5:
        if (r100 > 1.0f) goto L13;
        View r101 = findViewById(R.id.comm_background_shadow);
        if (r101 == null) goto L12;
        r101.setAlpha(r100);
        return;
    L12:
        return;
    }

    public void setButtonType(boolean r100) {
        View r101 = findViewById(R.id.comm_alert_button_1);
        int r102 = 4;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r103 = 4;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 0;
    L8:
        View r104 = findViewById(R.id.comm_alert_button_2);
        if (r104 == null) goto L13;
        if (r100 == false) goto L12;
        r102 = 0;
    L12:
        r104.setVisibility(r102);
    L13:
        this.hasCancel = r100;
    }

    public void setCancelColor(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_cancel);
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setCancelText(String r100) {
        setCancelText(r100, false);
    }

    public void setCommAlertOverlayListener(CommAlertOverlayListener r100) {
        this.commAlertOverlayListener = r100;
    }

    public void setConfirmColor(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_confirm);
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
    L5:
        TextView r102 = (TextView) findViewById(R.id.comm_alert_confirm1);
        if (r102 == null) goto L9;
        r102.setTextColor(r100);
        return;
    }

    public void setConfirmText(String r100) {
        setConfirmText(r100, false);
    }

    public void setMessageColor(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_message_text);
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setMessageText(String r100) {
        setMessageText(r100, false);
    }

    public void setMsgColor(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_message_text);
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setTitleColor(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_title_text);
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    public void setTitleText(String r100) {
        setTitleText(r100, false);
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        TextView r101 = (TextView) findViewById(R.id.comm_alert_title_text);
        if (r101 == null) goto L17;
        if (r100 != 0) goto L17;
        TextView r102 = (TextView) findViewById(R.id.comm_alert_message_text);
        if (r102 == null) goto L17;
        if (r102.getVisibility() != 0) goto L17;
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102.getLayoutParams();
        if (r101.getVisibility() != 8) goto L15;
        if (r103.topMargin != 0) goto L17;
        r103.setMargins(0, b.a(r102.getContext(), 25.0f), 0, b.a(r102.getContext(), 20.0f));
        goto L17
    L15:
        if (r103.topMargin == 0) goto L17;
        r103.setMargins(0, 0, 0, b.a(r102.getContext(), 20.0f));
    L17:
        super.setVisibility(r100);
    }

    public CommAlertOverlay(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.commAlertOverlayListener = null;
        this.hasCancel = true;
        setClickable(true);
        LayoutInflater.from(r100).inflate(getLayoutID(), this);
        if (getResources().getConfiguration().orientation != 2) goto L5;
        ViewGroup.LayoutParams r102 = ((LinearLayout) findViewById(R.id.ll_container)).getLayoutParams();
        r102.width = (b.d(r100).y * 270) / MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN;
    L5:
        View r103 = findViewById(R.id.comm_alert_cancel);
        if (r103 == null) goto L8;
        r103.setOnClickListener(new AnonymousClass1(this));
    L8:
        View r104 = findViewById(R.id.comm_alert_confirm);
        if (r104 == null) goto L11;
        r104.setOnClickListener(new AnonymousClass2(this));
    L11:
        View r105 = findViewById(R.id.comm_alert_confirm1);
        if (r105 == null) goto L15;
        r105.setOnClickListener(new AnonymousClass3(this));
        return;
    }

    public void setCancelText(String r100, boolean r101) {
        TextView r102 = (TextView) findViewById(R.id.comm_alert_cancel);
        if (r102 == null) goto L8;
        if (r101 == false) goto L6;
        r102.setText(Html.fromHtml(r100));
        return;
    L6:
        r102.setText(r100);
        return;
    }

    public void setConfirmText(String r100, boolean r101) {
        if (this.hasCancel == false) goto L12;
        TextView r102 = (TextView) findViewById(R.id.comm_alert_confirm);
        if (r102 == null) goto L18;
        if (r101 == false) goto L9;
        r102.setText(Html.fromHtml(r100));
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L11;
        r102.setVisibility(8);
        return;
    L11:
        r102.setText(r100);
        return;
    L18:
        return;
    L12:
        TextView r103 = (TextView) findViewById(R.id.comm_alert_confirm1);
        if (r103 == null) goto L22;
        if (r101 == false) goto L16;
        r103.setText(Html.fromHtml(r100));
        return;
    L16:
        r103.setText(r100);
        return;
    }

    public void setMessageText(String r100, boolean r101) {
        TextView r102 = (TextView) findViewById(R.id.comm_alert_message_text);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
        r102.setText(Html.fromHtml(r100));
        r102.setVisibility(0);
        return;
    L7:
        r102.setText(r100);
        if (TextUtils.isEmpty(r100) == false) goto L10;
        r102.setVisibility(8);
        return;
    L10:
        r102.setVisibility(0);
    }

    public void setTitleText(String r100, boolean r101) {
        TextView r102 = (TextView) findViewById(R.id.comm_alert_title_text);
        if (r102 == null) goto L12;
        if (r101 == false) goto L6;
        r102.setText(Html.fromHtml(r100));
    L8:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        r102.setVisibility(8);
        return;
    L10:
        r102.setVisibility(0);
        return;
    L6:
        r102.setText(r100);
        goto L8
    }

    public void updateStyle(int r100, int r101, int r102, int r103) {
        TextView r104 = (TextView) findViewById(R.id.comm_alert_cancel);
        if (r104 == null) goto L5;
        r104.setTextSize(1, r102);
    L5:
        TextView r105 = (TextView) findViewById(R.id.comm_alert_confirm);
        if (r105 == null) goto L8;
        r105.setTextSize(1, r103);
    L8:
        TextView r106 = (TextView) findViewById(R.id.comm_alert_confirm1);
        if (r106 == null) goto L11;
        r106.setTextSize(1, r103);
    L11:
        TextView r107 = (TextView) findViewById(R.id.comm_alert_title_text);
        if (r107 == null) goto L14;
        r107.setTextSize(1, r100);
    L14:
        TextView r108 = (TextView) findViewById(R.id.comm_alert_message_text);
        if (r108 == null) goto L18;
        r108.setTextSize(1, r101);
        return;
    }
}
