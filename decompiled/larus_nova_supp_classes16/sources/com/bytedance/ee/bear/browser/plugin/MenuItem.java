package com.bytedance.ee.bear.browser.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.bytedance.ee.bear.widgets.BadgeStyle;
import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class MenuItem implements NonProguard {
    private int badgeNum;
    private BadgeStyle badgeStyle;
    private String badgeText;
    private a clickInterceptor;
    private b clickListener;
    private List<String> customColor;
    private boolean enable;
    private Drawable icon;
    private String iconKey;
    private String id;
    private int lottieRawRes;
    private Boolean selected;
    private c showListener;
    private boolean showOnboard;
    private CharSequence spannableText;
    private String text;
    private boolean useOriginImageRendering;

    public interface a {
        void a(MenuItem r1, View r2);
    }

    public interface b {
        void a(MenuItem r1, View r2);
    }

    public interface c {
    }

    public MenuItem() {
        this(null, null);
    }

    public final void onShow(View r1) {
    }

    public void setShowListener(c r1) {
    }

    public String toString() {
        return String.format("Menu[%s,%s,selected=%s,enable=%s,showOnboard=%s,useOriginImageRendering=%s]", new Object[]{this.id, this.text, this.selected, Boolean.valueOf(this.enable), Boolean.valueOf(this.showOnboard), Boolean.valueOf(this.useOriginImageRendering)});
    }

    public int hashCode() {
        String r0 = this.id;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public int getBadgeNum() {
        return this.badgeNum;
    }

    public BadgeStyle getBadgeStyle() {
        return this.badgeStyle;
    }

    public String getBadgeText() {
        return this.badgeText;
    }

    public List<String> getCustomColor() {
        return this.customColor;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getIconKey() {
        return this.iconKey;
    }

    public String getId() {
        return this.id;
    }

    public int getLottieRawRes() {
        return this.lottieRawRes;
    }

    public CharSequence getSpannableText() {
        return this.spannableText;
    }

    public CharSequence getText() {
        return this.text;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public Boolean isSelected() {
        return this.selected;
    }

    public boolean isShowOnboard() {
        return this.showOnboard;
    }

    public boolean isUseOriginImageRendering() {
        return this.useOriginImageRendering;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.id, ((MenuItem) r3).id);
    }

    public final void onClick(View r2) {
        a r0 = this.clickInterceptor;
        if (r0 == null) goto L6;
        r0.a(this, r2);
        return;
    L6:
        b r1 = this.clickListener;
        if (r1 == null) goto L10;
        r1.a(this, r2);
        return;
    }

    public void setBadgeNum(int r1) {
        this.badgeNum = r1;
    }

    public void setBadgeStyle(BadgeStyle r1) {
        this.badgeStyle = r1;
    }

    public void setBadgeText(String r1) {
        this.badgeText = r1;
    }

    public void setClickInterceptor(a r1) {
        this.clickInterceptor = r1;
    }

    public void setClickListener(b r1) {
        this.clickListener = r1;
    }

    public void setCustomColor(List<String> r1) {
        this.customColor = r1;
    }

    public void setDisabled(boolean r1) {
        setEnable(!r1);
    }

    public void setEnable(boolean r1) {
        this.enable = r1;
    }

    public void setIcon(Drawable r1) {
        this.icon = r1;
    }

    public void setIconKey(String r1) {
        this.iconKey = r1;
    }

    public void setId(String r1) {
        this.id = r1;
    }

    public void setLottieRawRes(int r1) {
        this.lottieRawRes = r1;
    }

    public void setSelected(Boolean r1) {
        this.selected = r1;
    }

    public void setShowOnboard(boolean r1) {
        this.showOnboard = r1;
    }

    public void setSpannableText(CharSequence r1) {
        this.spannableText = r1;
    }

    public void setText(String r1) {
        this.text = r1;
    }

    public void setUseOriginImageRendering(boolean r1) {
        this.useOriginImageRendering = r1;
    }

    public MenuItem(String r2, String r3) {
        this(r2, null, r3);
    }

    public MenuItem(String r2, Drawable r3, String r4) {
        this.enable = true;
        this.useOriginImageRendering = false;
        this.lottieRawRes = -1;
        this.id = r2;
        this.icon = r3;
        this.text = r4;
    }

    public static MenuItem fromColorText(Context r2, int r3, int r4) {
        Resources r5 = r2.getResources();
        String r6 = r5.getString(r3);
        int r7 = r5.getColor(r4);
        SpannableStringBuilder r8 = new SpannableStringBuilder();
        r8.append(r6);
        r8.setSpan(new ForegroundColorSpan(r7), 0, r6.length(), 17);
        MenuItem r9 = new MenuItem();
        r9.spannableText = r8;
        r9.text = null;
        return r9;
    }
}
