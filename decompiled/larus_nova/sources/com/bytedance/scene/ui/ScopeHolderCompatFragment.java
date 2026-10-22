package com.bytedance.scene.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.scene.n;

/* JADX INFO: loaded from: classes19.dex */
public class ScopeHolderCompatFragment extends Fragment implements n.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f268827d;

    public ScopeHolderCompatFragment() {
        this.f268827d = n.f268740e.N80();
    }

    @Override // com.bytedance.scene.n.b
    public final n N80() {
        return this.f268827d;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(true);
    }
}
