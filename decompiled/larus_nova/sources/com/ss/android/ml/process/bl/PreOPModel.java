package com.ss.android.ml.process.bl;

import java.util.List;
import jfc.a;

/* JADX INFO: loaded from: classes38.dex */
public class PreOPModel implements a {
    public List<String> args;
    public String feature;
    public List<String> labels;
    public List<String> lables;
    public int length;

    /* JADX INFO: renamed from: op, reason: collision with root package name */
    public String f449133op;
    public List<Float> opts;
    public List<List<String>> targets;
    public String type;
    public int vector_length;
    public int vector_num;

    public PreOPModel() {
    }

    public List<String> getLabels() {
        List<String> r100 = this.labels;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.lables;
    }

    public String toString() {
        return "PreOPModel{feature='" + this.feature + "', op='" + this.f449133op + "', args=" + this.args + ", opts=" + this.opts + ", labels=" + getLabels() + ", length=" + this.length + ", type='" + this.type + "', vector_length=" + this.vector_length + ", vector_num=" + this.vector_num + '}';
    }

    public int getLength() {
        if (getVectorLength() <= 0) goto L9;
        if (getVectorNum() <= 0) goto L9;
        return getVectorLength() * getVectorNum();
    L9:
        return this.length;
    }

    public List<String> getArgs() {
        return this.args;
    }

    public String getFeature() {
        return this.feature;
    }

    public List<Float> getOPTs() {
        return this.opts;
    }

    public String getOperator() {
        return this.f449133op;
    }

    public List<List<String>> getTargets() {
        return this.targets;
    }

    @Override // jfc.a
    public String getType() {
        return this.type;
    }

    public int getVectorLength() {
        return this.vector_length;
    }

    public int getVectorNum() {
        return this.vector_num;
    }
}
