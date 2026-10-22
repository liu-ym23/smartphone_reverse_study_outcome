package org.bouncycastle.jce.provider;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXPolicyNode implements PolicyNode {
    protected List children;
    protected boolean critical;
    protected int depth;
    protected Set expectedPolicies;
    protected PolicyNode parent;
    protected Set policyQualifiers;
    protected String validPolicy;

    public PKIXPolicyNode(List r100, int r101, Set r102, PolicyNode r103, Set r104, String r105, boolean r106) {
        this.children = r100;
        this.depth = r101;
        this.expectedPolicies = r102;
        this.parent = r103;
        this.policyQualifiers = r104;
        this.validPolicy = r105;
        this.critical = r106;
    }

    public void addChild(PKIXPolicyNode r100) {
        this.children.add(r100);
        r100.setParent(this);
    }

    public Object clone() {
        return copy();
    }

    public PKIXPolicyNode copy() {
        HashSet r100 = new HashSet();
        Iterator r101 = this.expectedPolicies.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(new String((String) r101.next()));
        goto L4
    L6:
        HashSet r102 = new HashSet();
        Iterator r103 = this.policyQualifiers.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r102.add(new String((String) r103.next()));
        goto L8
    L10:
        PKIXPolicyNode r104 = new PKIXPolicyNode(new ArrayList(), this.depth, r100, null, r102, new String(this.validPolicy), this.critical);
        Iterator r105 = this.children.iterator();
    L12:
        if (r105.hasNext() == false) goto L14;
        PKIXPolicyNode r106 = ((PKIXPolicyNode) r105.next()).copy();
        r106.setParent(r104);
        r104.addChild(r106);
        goto L12
    L14:
        return r104;
    }

    @Override // java.security.cert.PolicyNode
    public Iterator getChildren() {
        return this.children.iterator();
    }

    @Override // java.security.cert.PolicyNode
    public int getDepth() {
        return this.depth;
    }

    @Override // java.security.cert.PolicyNode
    public Set getExpectedPolicies() {
        return this.expectedPolicies;
    }

    @Override // java.security.cert.PolicyNode
    public PolicyNode getParent() {
        return this.parent;
    }

    @Override // java.security.cert.PolicyNode
    public Set getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    @Override // java.security.cert.PolicyNode
    public String getValidPolicy() {
        return this.validPolicy;
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    @Override // java.security.cert.PolicyNode
    public boolean isCritical() {
        return this.critical;
    }

    public void removeChild(PKIXPolicyNode r100) {
        this.children.remove(r100);
    }

    public void setCritical(boolean r100) {
        this.critical = r100;
    }

    public void setExpectedPolicies(Set r100) {
        this.expectedPolicies = r100;
    }

    public void setParent(PKIXPolicyNode r100) {
        this.parent = r100;
    }

    public String toString() {
        return toString("");
    }

    public String toString(String r100) {
        StringBuffer r101 = new StringBuffer();
        r101.append(r100);
        r101.append(this.validPolicy);
        r101.append(" {\n");
        int r102 = 0;
    L4:
        if (r102 >= this.children.size()) goto L6;
        r101.append(((PKIXPolicyNode) ListProtector.get(this.children, r102)).toString(r100 + LineContent.FOUR_SPACE));
        r102 = r102 + 1;
        goto L4
    L6:
        r101.append(r100);
        r101.append("}\n");
        return r101.toString();
    }
}
