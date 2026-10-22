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
import com.larus.nova.R;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.doc.entity.DocPermPair;
import com.ss.android.lark.doc.entity.DocPermission;
import com.ss.android.lark.doc.entity.DocResult;
import com.ss.android.lark.doc.entity.DocType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.ToggleButton;
import com.ss.android.lark.widget.dialog.BottomSheetListDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class ChatDocAuthSeletorAdapter extends RecyclerView.Adapter<DocAuthViewHolder> implements View.OnClickListener, ToggleButton.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f227479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f227480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DocResult> f227481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, DocPermPair.PermType> f227482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet<Integer> f227483e;

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

        public DocAuthViewHolder(LayoutInflater r100, ViewGroup r101, View.OnClickListener r102, ToggleButton.a r103) {
            super(r100.inflate(R.layout.chat_doc_auth_select_item, r101, false));
            ButterKnife.bind(this, this.itemView);
            this.itemView.setOnClickListener(r102);
            this.docPermSwitcher.setOnCheckedChangeListener(r103);
        }
    }

    public class DocAuthViewHolder_ViewBinding implements Unbinder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public DocAuthViewHolder f227484a;

        @Override // butterknife.Unbinder
        public final void unbind() {
            DocAuthViewHolder r100 = this.f227484a;
            if (r100 == null) goto L7;
            this.f227484a = null;
            r100.docAuthItemCheckbox = null;
            r100.docAuthItemIcon = null;
            r100.docAuthItemName = null;
            r100.docAuthItemDesc = null;
            r100.docPermSwitcher = null;
            r100.divider = null;
            return;
        L7:
            throw new IllegalStateException("Bindings already cleared.");
        }

        public DocAuthViewHolder_ViewBinding(DocAuthViewHolder r100, View r101) {
            this.f227484a = r100;
            r100.docAuthItemCheckbox = (UDCheckBox) Utils.findRequiredViewAsType(r101, R.id.doc_auth_item_checkbox, "field 'docAuthItemCheckbox'", UDCheckBox.class);
            r100.docAuthItemIcon = (ImageView) Utils.findRequiredViewAsType(r101, R.id.doc_auth_item_icon, "field 'docAuthItemIcon'", ImageView.class);
            r100.docAuthItemName = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_auth_item_name, "field 'docAuthItemName'", TextView.class);
            r100.docAuthItemDesc = (TextView) Utils.findRequiredViewAsType(r101, R.id.doc_auth_item_desc, "field 'docAuthItemDesc'", TextView.class);
            r100.docPermSwitcher = (ToggleButton) Utils.findRequiredViewAsType(r101, R.id.doc_auth_item_permission_switcher, "field 'docPermSwitcher'", ToggleButton.class);
            r100.divider = Utils.findRequiredView(r101, R.id.doc_auth_item_divider, "field 'divider'");
        }
    }

    public interface a {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return ((ArrayList) this.f227481c).size();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = ((Integer) r100.getTag()).intValue();
        if (this.f227483e.contains(Integer.valueOf(r101)) == false) goto L5;
        this.f227483e.remove(Integer.valueOf(r101));
    L6:
        notifyItemChanged(r101);
        a r102 = this.f227480b;
        if (r102 == null) goto L10;
        DocAuthSelectorDialog.a r103 = (DocAuthSelectorDialog.a) r102;
        int r104 = r103.f227488a.f227483e.size();
        ((BottomSheetListDialog) r103.f227489b.getDialog()).I0(UIHelper.mustacheFormat(R.string.Lark_Legacy_ChatDocAuthCountBtn, "count", Integer.toString(r104)));
        return;
    L10:
        return;
    L5:
        this.f227483e.add(Integer.valueOf(r101));
        goto L6
    }

    public ChatDocAuthSeletorAdapter(Context r100, List<DocResult> r101) {
        this.f227479a = LayoutInflater.from(r100);
        this.f227481c = new ArrayList(r101);
        this.f227483e = new HashSet();
        this.f227482d = new HashMap();
        int r102 = 0;
    L4:
        if (r102 >= this.f227481c.size()) goto L15;
        this.f227483e.add(Integer.valueOf(r102));
        DocResult r103 = (DocResult) ListProtector.get(this.f227481c, r102);
        Iterator<DocPermission> r104 = r103.getDocCard().getPermissions().iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        DocPermission r105 = r104.next();
        if (r105.isSet() == false) goto L7;
        this.f227482d.put(r103.getDoc().getUrl(), DocPermPair.PermType.forNumber(r105.getPermTypeNum()));
        boolean r106 = true;
    L12:
        if (r106 == true) goto L14;
        this.f227482d.put(r103.getDoc().getUrl(), DocPermPair.PermType.READ);
    L14:
        r102 = r102 + 1;
        goto L4
    L11:
        r106 = false;
        goto L12
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r100, int r101) {
        DocAuthViewHolder r102 = (DocAuthViewHolder) r100;
        DocResult r103 = (DocResult) ListProtector.get(this.f227481c, r101);
        DocPermPair.PermType r104 = this.f227482d.get(r103.getDoc().getUrl());
        DocResult r105 = (DocResult) ListProtector.get(this.f227481c, r101);
        boolean r106 = this.f227483e.contains(Integer.valueOf(r101));
        r102.docPermSwitcher.setTag(r105);
        r102.docPermSwitcher.setTag(r105);
        r102.itemView.setTag(Integer.valueOf(r101));
        Doc r107 = r105.getDoc();
        DocType r108 = r107.getDocType();
        String r109 = r107.getName();
        int r110 = DocModuleInner.a(r108, DocType.UNKNOWN_DOC_TYPE, r109);
        r102.docAuthItemIcon.setImageResource(r110);
        String r111 = r107.getName();
        String r112 = r107.getOwnerName();
        r102.docAuthItemCheckbox.setChecked(r106);
        r102.docAuthItemName.setText(r111);
        String r113 = UIHelper.mustacheFormat(R.string.Lark_Legacy_DocsPreviewOwner, "owner", r112);
        r102.docAuthItemDesc.setText(r113);
        boolean r114 = false;
        if (r105.getDocCard() != null) goto L5;
    L7:
        boolean r115 = false;
    L8:
        ToggleButton r116 = r102.docPermSwitcher;
        DocPermPair.PermType r117 = DocPermPair.PermType.EDIT;
        if (r104 != r117) goto L11;
        boolean r118 = true;
    L12:
        r116.setChecked(r118);
        ToggleButton r119 = r102.docPermSwitcher;
        if (r115 == true) goto L15;
        if (r104 == r117) goto L15;
    L16:
        r119.setEnabled(r114);
        return;
    L15:
        r114 = true;
        goto L16
    L11:
        r118 = false;
        goto L12
    L5:
        if (r105.getDocCard().getPermissions().size() <= 1) goto L7;
        r115 = true;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        return new DocAuthViewHolder(this.f227479a, r100, this, this);
    }
}
