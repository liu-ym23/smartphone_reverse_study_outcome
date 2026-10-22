package com.bytedance.ee.bear.lark.selector.auth;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.bytedance.ee.bear.lark.selector.DocModuleInner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ToggleButton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class ChatDocAuthSeletorAdapter extends RecyclerView.Adapter<DocAuthViewHolder> implements View.OnClickListener, ToggleButton.a {
    public final LayoutInflater a;
    public a b;
    public final List<DocResult> c;
    public final HashMap<String, DocPermPair.PermType> d;
    public final HashSet<Integer> e;

    public static class DocAuthViewHolder extends RecyclerView.ViewHolder {

        @BindView(12028)
        View divider;

        @BindView(12026)
        UDCheckBox docAuthItemCheckbox;

        @BindView(12027)
        TextView docAuthItemDesc;

        @BindView(12029)
        ImageView docAuthItemIcon;

        @BindView(12030)
        TextView docAuthItemName;

        @BindView(12031)
        ToggleButton docPermSwitcher;

        public DocAuthViewHolder(LayoutInflater r3, ViewGroup r4, View.OnClickListener r5, ToggleButton.a r6) {
            super(r3.inflate(2131559281, r4, false));
            ButterKnife.bind(this, ((RecyclerView.ViewHolder) this).itemView);
            ((RecyclerView.ViewHolder) this).itemView.setOnClickListener(r5);
            this.docPermSwitcher.setOnCheckedChangeListener(r6);
        }
    }

    public class DocAuthViewHolder_ViewBinding implements Unbinder {
        public DocAuthViewHolder a;

        public final void unbind() {
            DocAuthViewHolder r0 = this.a;
            if (r0 == null) goto L7;
            this.a = null;
            r0.docAuthItemCheckbox = null;
            r0.docAuthItemIcon = null;
            r0.docAuthItemName = null;
            r0.docAuthItemDesc = null;
            r0.docPermSwitcher = null;
            r0.divider = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public DocAuthViewHolder_ViewBinding(DocAuthViewHolder r4, View r5) {
            this.a = r4;
            r4.docAuthItemCheckbox = (UDCheckBox) Utils.findRequiredViewAsType(r5, 2131369267, "field 'docAuthItemCheckbox'", UDCheckBox.class);
            r4.docAuthItemIcon = (ImageView) Utils.findRequiredViewAsType(r5, 2131369270, "field 'docAuthItemIcon'", ImageView.class);
            r4.docAuthItemName = (TextView) Utils.findRequiredViewAsType(r5, 2131369271, "field 'docAuthItemName'", TextView.class);
            r4.docAuthItemDesc = (TextView) Utils.findRequiredViewAsType(r5, 2131369268, "field 'docAuthItemDesc'", TextView.class);
            r4.docPermSwitcher = (ToggleButton) Utils.findRequiredViewAsType(r5, 2131369272, "field 'docPermSwitcher'", ToggleButton.class);
            r4.divider = Utils.findRequiredView(r5, 2131369269, "field 'divider'");
        }
    }

    public interface a {
    }

    public final int getItemCount() {
        return ((ArrayList) this.c).size();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        int r5 = ((Integer) r4.getTag()).intValue();
        if (this.e.contains(Integer.valueOf(r5)) == false) goto L5;
        this.e.remove(Integer.valueOf(r5));
    L6:
        notifyItemChanged(r5);
        a r6 = this.b;
        if (r6 == null) goto L10;
        DocAuthSelectorDialog.a r7 = (DocAuthSelectorDialog.a) r6;
        int r0 = r7.a.e.size();
        r7.b.getDialog().I0(UIHelper.mustacheFormat(2131891553, "count", Integer.toString(r0)));
        return;
    L10:
        return;
    L5:
        this.e.add(Integer.valueOf(r5));
        goto L6
    }

    public ChatDocAuthSeletorAdapter(Context r5, List<DocResult> r6) {
        this.a = LayoutInflater.from(r5);
        this.c = new ArrayList(r6);
        this.e = new HashSet();
        this.d = new HashMap();
        int r7 = 0;
    L4:
        if (r7 >= this.c.size()) goto L15;
        this.e.add(Integer.valueOf(r7));
        DocResult r0 = (DocResult) ListProtector.get(this.c, r7);
        Iterator r1 = r0.getDocCard().getPermissions().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        DocPermission r2 = (DocPermission) r1.next();
        if (r2.isSet() == false) goto L7;
        this.d.put(r0.getDoc().getUrl(), DocPermPair.PermType.forNumber(r2.getPermTypeNum()));
        boolean r3 = true;
    L12:
        if (r3 == true) goto L14;
        this.d.put(r0.getDoc().getUrl(), DocPermPair.PermType.READ);
    L14:
        r7 = r7 + 1;
        goto L4
    L11:
        r3 = false;
        goto L12
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r7, int r8) {
        DocAuthViewHolder r9 = (DocAuthViewHolder) r7;
        DocResult r0 = (DocResult) ListProtector.get(this.c, r8);
        DocPermPair.PermType r1 = this.d.get(r0.getDoc().getUrl());
        DocResult r2 = (DocResult) ListProtector.get(this.c, r8);
        boolean r3 = this.e.contains(Integer.valueOf(r8));
        r9.docPermSwitcher.setTag(r2);
        r9.docPermSwitcher.setTag(r2);
        ((RecyclerView.ViewHolder) r9).itemView.setTag(Integer.valueOf(r8));
        Doc r10 = r2.getDoc();
        DocType r4 = r10.getDocType();
        String r5 = r10.getName();
        int r6 = DocModuleInner.a(r4, DocType.UNKNOWN_DOC_TYPE, r5);
        r9.docAuthItemIcon.setImageResource(r6);
        String r11 = r10.getName();
        String r12 = r10.getOwnerName();
        r9.docAuthItemCheckbox.setChecked(r3);
        r9.docAuthItemName.setText(r11);
        String r13 = UIHelper.mustacheFormat(2131891688, "owner", r12);
        r9.docAuthItemDesc.setText(r13);
        boolean r14 = false;
        if (r2.getDocCard() != null) goto L5;
    L7:
        boolean r16 = false;
    L8:
        ToggleButton r17 = r9.docPermSwitcher;
        DocPermPair.PermType r18 = DocPermPair.PermType.EDIT;
        if (r1 != r18) goto L11;
        boolean r19 = true;
    L12:
        r17.setChecked(r19);
        ToggleButton r20 = r9.docPermSwitcher;
        if (r16 == true) goto L15;
        if (r1 == r18) goto L15;
    L16:
        r20.setEnabled(r14);
        return;
    L15:
        r14 = true;
        goto L16
    L11:
        r19 = false;
        goto L12
    L5:
        if (r2.getDocCard().getPermissions().size() <= 1) goto L7;
        r16 = true;
        goto L8
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new DocAuthViewHolder(this.a, r2, this, this);
    }
}
