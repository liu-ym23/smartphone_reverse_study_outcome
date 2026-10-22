package com.bytedance.ee.bear.mindnote.toolbar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.doc.toolbar.DocItemId;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelFragment;
import com.bytedance.ee.bear.document.toolbar.BaseToolbarPanelViewModel;
import com.bytedance.ee.bear.document.toolbar.Item;
import com.bytedance.ee.bear.document.toolbar.ItemId;
import com.bytedance.ee.bear.document.toolbar.media.impl.InsertMediaCompatFragment;
import com.bytedance.ee.bear.document.toolbar.media.impl.SelectMediaViewModel;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import com.bytedance.ee.bear.fileselector.FileSelectFragment;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.bytedance.ee.bear.fileselector.d;
import com.bytedance.ee.util.ui.n;
import j45.b;
import java.util.ArrayList;
import java.util.Iterator;
import jj5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class MindNoteToolbarFragment extends BaseToolbarPanelFragment<MindNoteToolbar> {
    public static final /* synthetic */ int w = 0;
    public View r;
    public HorizontalOverScrollView s;
    public c t;
    public SelectMediaViewModel u;
    public j45.c v;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MindNoteItemId.values().length];
            a = r0;
            r0[MindNoteItemId.outdent.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L28:
            a[MindNoteItemId.indent.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            a[MindNoteItemId.finish.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L46:
            a[MindNoteItemId.mention.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L30:
            a[MindNoteItemId.note.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L36:
            a[MindNoteItemId.insertImage.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L40:
            a[MindNoteItemId.mnAttribute.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L42:
            a[MindNoteItemId.comment.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L26:
            a[MindNoteItemId.undo.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L32:
            a[MindNoteItemId.redo.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L38:
            a[MindNoteItemId.delete.ordinal()] = 11;     // Catch: NoSuchFieldError -> L25
            return;
        }
    }

    public final void V90(int r1) {
    }

    public final void X90() {
        if (aa0(getActivity()).getToolbar().getValue() != null) goto L6;
        super.X90();
        return;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        HorizontalOverScrollView r0 = this.s;
        c r1 = this.t;
        ((ArrayList) r0.a).remove(r1);
    }

    static {
    }

    public MindNoteToolbarFragment() {
    }

    public final void W90(boolean r4) {
        super.W90(r4);
        ((MindNoteToolbarViewModel) aa0(getActivity())).setIsShowingSubToolBar(false);
        FragmentActivity r5 = getActivity();
        Iterator r0 = r5.getSupportFragmentManager().getFragments().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if ((((Fragment) r0.next()) instanceof FileSelectFragment) == false) goto L4;
        FragmentManager r1 = r5.getSupportFragmentManager();
        int r2 = d.a;
        d.a.a(r1, "MindNoteToolbarFragment");
        goto L4
    }

    public final Class<? extends DialogFragment> Y90(ItemId r4) {
        if (r4 != MindNoteItemId.mnAttribute) goto L7;
        return MindNoteTxtAttrFragment.class;
    L7:
        if (r4 != MindNoteItemId.insertImage) goto L11;
        return InsertMediaCompatFragment.class;
    L11:
        throw new IllegalStateException("get subToolbarFragmentClass on:" + r4);
    }

    public final int Z90(ItemId r2) {
        switch(a.a[((MindNoteItemId) r2).ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L4;
        };
    L4:
        return 0;
    L5:
        return 2131254201;
    L6:
        return 2131255522;
    L7:
        return 2131256063;
    L8:
        return 2131253538;
    L9:
        return 2131255997;
    L10:
        return 2131254899;
    L11:
        return 2131254283;
    L12:
        return 2131253681;
    L13:
        return 2131256017;
    L14:
        return 2131254912;
    L15:
        return 2131255523;
    }

    public final BaseToolbarPanelViewModel aa0(FragmentActivity r1) {
        return q.a(this, MindNoteToolbarViewModel.class);
    }

    public final void ea0(ItemId r5) {
        FragmentActivity r0 = getActivity();
        if (DocItemId.insertImage.name().equals(r5.name()) == false) goto L8;
        j45.c r6 = this.v;
        FileSelectConfig.e r1 = this.u.getDefaultBuilder(r0);
        ((FileSelectConfig.c) r1).a.autoDismiss = false;
        r6.getClass();
        ((FileSelectConfig.c) r1).a.onDismissListener = new j45.a(r6, r0);
        FragmentManager r2 = r0.getSupportFragmentManager();
        FileSelectConfig r3 = r1.a();
        int r4 = d.a;
        r6.a = d.a.c(r0, r2, r3, "MindNoteToolbarFragment");
        j45.c r7 = this.v;
        BaseCommonActivity r8 = getActivity();
        r7.getClass();
        if ((r8 instanceof BaseCommonActivity) == false) goto L9;
        b r9 = new b(r7, r8);
        r7.b = r9;
        r8.Xi(r9);
    L9:
        if (r0 != null) goto L11;
        return;
    L11:
        if (n.D(r0) == false) goto L15;
        ((MindNoteToolbarViewModel) aa0(r0)).setIsShowingSubToolBar(true);
        rcb.c.c(r0);
        return;
    L15:
        return;
    L8:
        super.ea0(r5);
        goto L9
    }

    public final void fa0(Item r4, View r5) {
        AppCompatImageView r0 = r5.findViewById(2131389061);
        r0.setBackgroundTintList(getResources().getColorStateList(2131103620));
        r0.setImageTintList(getResources().getColorStateList(2131106629));
        super.fa0(r4, r5);
    }

    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object, jj5.c] */
    public final void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        Bundle r7 = getArguments();
        if (r7 == null) goto L5;
        BearUrl r1 = (BearUrl) r7.getParcelable("bear_url");
        String r8 = r7.getString("origin_bear_url");
    L6:
        ((jj5.a) org.koin.java.a.b(jj5.a.class, null, new jj5.b(this))).a("ccm_bottom_toolbar_view", r1, r8);
        this.u = ViewModelProviders.of(getActivity()).get(SelectMediaViewModel.class);
        this.r = r5.findViewById(2131379535);
        HorizontalOverScrollView r9 = r5.findViewById(2131374527);
        this.s = r9;
        ?? r10 = new c(this);
        this.t = r10;
        ((ArrayList) r9.a).add(r10);
        this.v = new j45.c();
        return;
    L5:
        r8 = null;
        r1 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131563650, r3, false);
    }
}
