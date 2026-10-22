package com.ss.android.lark.desktopmode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.app.DesktopCompatFragment;

/* JADX INFO: loaded from: classes35.dex */
public class EmptyFrameFragment extends DesktopCompatFragment {
    public EmptyFrameFragment() {
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.empty_frame_fragment_layout, r101, false);
        ImageView r104 = (ImageView) r103.findViewById(R.id.holder);
        if (getArguments() == null) goto L7;
        int r105 = getArguments().getInt("holder");
        if (r105 == (-1)) goto L7;
        r104.setImageResource(r105);
    L7:
        return r103;
    }
}
