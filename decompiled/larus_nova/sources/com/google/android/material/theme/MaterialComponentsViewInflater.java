package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.widget.AppCompatButton;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes23.dex */
public class MaterialComponentsViewInflater extends AppCompatViewInflater {
    public MaterialComponentsViewInflater() {
    }

    @Override // androidx.appcompat.app.AppCompatViewInflater
    public AppCompatButton createButton(Context r100, AttributeSet r101) {
        return new MaterialButton(r100, r101);
    }
}
