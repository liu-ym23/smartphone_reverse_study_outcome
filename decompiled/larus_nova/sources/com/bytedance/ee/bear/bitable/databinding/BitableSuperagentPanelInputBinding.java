package com.bytedance.ee.bear.bitable.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.superagent.voice.BitableSuperAgentVoiceStateButton;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableSuperagentPanelInputBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDShadowLayout f211053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f211054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BitableAtEditText f211055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConstraintLayout f211056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f211057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BitableSuperAgentVoiceStateButton f211058f;

    @Override // androidx.viewbinding.ViewBinding
    public final View getRoot() {
        return this.f211053a;
    }

    public BitableSuperagentPanelInputBinding(UDShadowLayout r100, AppCompatImageView r101, BitableAtEditText r102, ConstraintLayout r103, AppCompatImageView r104, BitableSuperAgentVoiceStateButton r105) {
        this.f211053a = r100;
        this.f211054b = r101;
        this.f211055c = r102;
        this.f211056d = r103;
        this.f211057e = r104;
        this.f211058f = r105;
    }
}
