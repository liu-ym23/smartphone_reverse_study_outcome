package com.bytedance.ee.bear.sheet.inputbar.formula;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FormulaSignatureHelpData implements NonProguard {
    private int activeParam;
    private String functionName;
    private List<Param> params;
    private String requestId;
    private String returnType;

    public static class Param implements NonProguard {
        private String name;
        private boolean optional;
        private String type;

        public Param() {
        }

        public String getName() {
            return this.name;
        }

        public String getType() {
            return this.type;
        }

        public boolean isOptional() {
            return this.optional;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public void setOptional(boolean r1) {
            this.optional = r1;
        }

        public void setType(String r1) {
            this.type = r1;
        }
    }

    public FormulaSignatureHelpData() {
    }

    public int getActiveParam() {
        return this.activeParam;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public List<Param> getParams() {
        return this.params;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getReturnType() {
        return this.returnType;
    }

    public void setActiveParam(int r1) {
        this.activeParam = r1;
    }

    public void setFunctionName(String r1) {
        this.functionName = r1;
    }

    public void setParams(List<Param> r1) {
        this.params = r1;
    }

    public void setRequestId(String r1) {
        this.requestId = r1;
    }

    public void setReturnType(String r1) {
        this.returnType = r1;
    }
}
