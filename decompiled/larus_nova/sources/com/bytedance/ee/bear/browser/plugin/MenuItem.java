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

/* JADX INFO: loaded from: classes16.dex */
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

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f216610id;
    private int lottieRawRes;
    private Boolean selected;
    private c showListener;
    private boolean showOnboard;
    private CharSequence spannableText;
    private String text;
    private boolean useOriginImageRendering;

    public interface a {
        void a(MenuItem r100, View r101);
    }

    public interface b {
        void a(MenuItem r100, View r101);
    }

    public interface c {
    }

    public MenuItem() {
        this(null, null);
    }

    public final void onShow(View r100) {
    }

    public void setShowListener(c r100) {
    }

    public String toString() {
        return String.format("Menu[%s,%s,selected=%s,enable=%s,showOnboard=%s,useOriginImageRendering=%s]", new Object[]{this.f216610id, this.text, this.selected, Boolean.valueOf(this.enable), Boolean.valueOf(this.showOnboard), Boolean.valueOf(this.useOriginImageRendering)});
    }

    public int hashCode() {
        String r100 = this.f216610id;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
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
        return this.f216610id;
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

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if (getClass() == r100.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.f216610id, ((MenuItem) r100).f216610id);
    }

    public final void onClick(View r100) {
        a r101 = this.clickInterceptor;
        if (r101 == null) goto L6;
        r101.a(this, r100);
        return;
    L6:
        b r102 = this.clickListener;
        if (r102 == null) goto L10;
        r102.a(this, r100);
        return;
    }

    public void setBadgeNum(int r100) {
        this.badgeNum = r100;
    }

    public void setBadgeStyle(BadgeStyle r100) {
        this.badgeStyle = r100;
    }

    public void setBadgeText(String r100) {
        this.badgeText = r100;
    }

    public void setClickInterceptor(a r100) {
        this.clickInterceptor = r100;
    }

    public void setClickListener(b r100) {
        this.clickListener = r100;
    }

    public void setCustomColor(List<String> r100) {
        this.customColor = r100;
    }

    public void setDisabled(boolean r100) {
        setEnable(!r100);
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setIcon(Drawable r100) {
        this.icon = r100;
    }

    public void setIconKey(String r100) {
        this.iconKey = r100;
    }

    public void setId(String r100) {
        this.f216610id = r100;
    }

    public void setLottieRawRes(int r100) {
        this.lottieRawRes = r100;
    }

    public void setSelected(Boolean r100) {
        this.selected = r100;
    }

    public void setShowOnboard(boolean r100) {
        this.showOnboard = r100;
    }

    public void setSpannableText(CharSequence r100) {
        this.spannableText = r100;
    }

    public void setText(String r100) {
        this.text = r100;
    }

    public void setUseOriginImageRendering(boolean r100) {
        this.useOriginImageRendering = r100;
    }

    public MenuItem(String r100, String r101) {
        this(r100, null, r101);
    }

    public MenuItem(String r100, Drawable r101, String r102) {
        this.enable = true;
        this.useOriginImageRendering = false;
        this.lottieRawRes = -1;
        this.f216610id = r100;
        this.icon = r101;
        this.text = r102;
    }

    public static MenuItem fromColorText(Context r100, int r101, int r102) {
        Resources r103 = r100.getResources();
        String r104 = r103.getString(r101);
        int r105 = r103.getColor(r102);
        SpannableStringBuilder r106 = new SpannableStringBuilder();
        r106.append(r104);
        r106.setSpan(new ForegroundColorSpan(r105), 0, r104.length(), 17);
        MenuItem r107 = new MenuItem();
        r107.spannableText = r106;
        r107.text = null;
        return r107;
    }
}
