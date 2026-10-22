package com.dtf.face.config;

import com.alibaba.fastjson.annotation.JSONField;
import com.ss.ttvideoengine.net.DNSParser;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class AndroidDocConfig {

    @JSONField(name = "coll")
    public Coll coll;

    @JSONField(name = "eidlink")
    private Eidlink eidlink;

    @JSONField(name = "fillback")
    private FillBack fillBack;

    @JSONField(name = "navi")
    public NavigatePage navi;

    @JSONField(name = "passportInfo")
    private PassportInfo passportInfo;

    @JSONField(name = "scanAlgorithm")
    public List<ScanAlgorithm> scanAlgorithm;

    @JSONField(name = "token")
    public String token;

    @JSONField(name = "upload")
    public Upload upload;

    public class Eidlink {

        @JSONField(name = "appid")
        private String appid;

        @JSONField(name = "envCode")
        private String envCode;

        /* JADX INFO: renamed from: ip, reason: collision with root package name */
        @JSONField(name = DNSParser.DNS_RESULT_IP)
        private String f273638ip;

        @JSONField(name = "port")
        private String port;

        @JSONField(name = "port2")
        private String port2;
        public final /* synthetic */ AndroidDocConfig this$0;

        public String getAppid() {
            return this.appid;
        }

        public String getEnvCode() {
            return this.envCode;
        }

        public String getIp() {
            return this.f273638ip;
        }

        public String getPort() {
            return this.port;
        }

        public String getPort2() {
            return this.port2;
        }

        public Eidlink(AndroidDocConfig r100) {
            this.this$0 = r100;
            this.envCode = "";
            this.port = "";
            this.port2 = "";
            this.appid = "";
            this.f273638ip = "";
        }

        public void setAppid(String r100) {
            this.appid = r100;
        }

        public void setEnvCode(String r100) {
            this.envCode = r100;
        }

        public void setIp(String r100) {
            this.f273638ip = r100;
        }

        public void setPort(String r100) {
            this.port = r100;
        }

        public void setPort2(String r100) {
            this.port2 = r100;
        }
    }

    public class PassportInfo {

        @JSONField(name = "passportBirth")
        private String passportBirth;

        @JSONField(name = "passportExpire")
        private String passportExpire;

        @JSONField(name = "passportNo")
        private String passportNo;
        public final /* synthetic */ AndroidDocConfig this$0;

        public String toString() {
            return "PassportInfo{passportNo='" + this.passportNo + "', passportBirth='" + this.passportBirth + "', passportExpire='" + this.passportExpire + "'}";
        }

        public String getPassportBirth() {
            return this.passportBirth;
        }

        public String getPassportExpire() {
            return this.passportExpire;
        }

        public String getPassportNo() {
            return this.passportNo;
        }

        public PassportInfo(AndroidDocConfig r100) {
            this.this$0 = r100;
            this.passportNo = "";
        }

        public void setPassportBirth(String r100) {
            this.passportBirth = r100;
        }

        public void setPassportExpire(String r100) {
            this.passportExpire = r100;
        }

        public void setPassportNo(String r100) {
            this.passportNo = r100;
        }
    }

    public static class ScanAlgorithm {

        @JSONField(name = "boundaryThreshold")
        public float boundaryThreshold;

        @JSONField(name = "cameraMaxWidth")
        public int cameraMaxWidth;

        @JSONField(name = "faceROI")
        public FaceROI faceROI;

        @JSONField(name = "faceThreshold")
        public int faceThreshold;

        @JSONField(name = "flash")
        public int flash;

        @JSONField(name = "logLevel")
        public int logLevel;

        @JSONField(name = "plateType")
        public String plateType;

        @JSONField(name = "showDuration")
        public int showDuration;

        @JSONField(name = "stackTime")
        public int stackTime;

        @JSONField(name = "subType")
        public String subType;

        @JSONField(name = "thickness")
        public int thickness;

        @JSONField(name = "useFlash")
        public boolean useFlash;

        public static class FaceROI {

            @JSONField(name = "bottom")
            public float bottom;

            @JSONField(name = "left")
            public float left;

            @JSONField(name = "right")
            public float right;

            @JSONField(name = "top")
            public float top;

            public FaceROI() {
            }
        }

        public ScanAlgorithm() {
        }
    }

    public AndroidDocConfig() {
    }

    public Coll getColl() {
        return this.coll;
    }

    public Eidlink getEidlink() {
        return this.eidlink;
    }

    public FillBack getFillBack() {
        return this.fillBack;
    }

    public NavigatePage getNavi() {
        return this.navi;
    }

    public PassportInfo getPassportInfo() {
        return this.passportInfo;
    }

    public void setColl(Coll r100) {
        this.coll = r100;
    }

    public void setEidlink(Eidlink r100) {
        this.eidlink = r100;
    }

    public void setFillBack(FillBack r100) {
        this.fillBack = r100;
    }

    public void setNavi(NavigatePage r100) {
        this.navi = r100;
    }

    public void setPassportInfo(PassportInfo r100) {
        this.passportInfo = r100;
    }
}
