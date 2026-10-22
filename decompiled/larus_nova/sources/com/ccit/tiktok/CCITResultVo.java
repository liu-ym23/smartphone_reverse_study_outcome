package com.ccit.tiktok;

/* JADX INFO: loaded from: classes22.dex */
public class CCITResultVo {
    private String HMAC;
    private String certAlg;
    private String certDN;
    private String certIssureDN;
    private String certNotAfter;
    private String certNotBefore;
    private String certSN;
    private String certVersion;
    private String csr;
    private String encData;
    private String encKey;
    private String publicKey;
    private String q1Id;
    private String resultCode;
    private String resultMsg;

    public CCITResultVo() {
    }

    public String toString() {
        return "CCITResultVo{resultCode='" + this.resultCode + "', resultMsg='" + this.resultMsg + "', encKey='" + this.encKey + "', encData='" + this.encData + "', HMAC='" + this.HMAC + "', csr='" + this.csr + "', q1Id='" + this.q1Id + "', certDN='" + this.certDN + "', certIssureDN='" + this.certIssureDN + "', certVersion='" + this.certVersion + "', certSN='" + this.certSN + "', certNotBefore='" + this.certNotBefore + "', certNotAfter='" + this.certNotAfter + "', certAlg='" + this.certAlg + "', publicKey='" + this.publicKey + "'}";
    }

    public String getCertAlg() {
        return this.certAlg;
    }

    public String getCertDN() {
        return this.certDN;
    }

    public String getCertIssureDN() {
        return this.certIssureDN;
    }

    public String getCertNotAfter() {
        return this.certNotAfter;
    }

    public String getCertNotBefore() {
        return this.certNotBefore;
    }

    public String getCertSN() {
        return this.certSN;
    }

    public String getCertVersion() {
        return this.certVersion;
    }

    public String getCsr() {
        return this.csr;
    }

    public String getEncData() {
        return this.encData;
    }

    public String getEncKey() {
        return this.encKey;
    }

    public String getHMAC() {
        return this.HMAC;
    }

    public String getPublicKey() {
        return this.publicKey;
    }

    public String getQ1Id() {
        return this.q1Id;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setCertAlg(String r100) {
        this.certAlg = r100;
    }

    public void setCertDN(String r100) {
        this.certDN = r100;
    }

    public void setCertIssureDN(String r100) {
        this.certIssureDN = r100;
    }

    public void setCertNotAfter(String r100) {
        this.certNotAfter = r100;
    }

    public void setCertNotBefore(String r100) {
        this.certNotBefore = r100;
    }

    public void setCertSN(String r100) {
        this.certSN = r100;
    }

    public void setCertVersion(String r100) {
        this.certVersion = r100;
    }

    public void setCsr(String r100) {
        this.csr = r100;
    }

    public void setEncData(String r100) {
        this.encData = r100;
    }

    public void setEncKey(String r100) {
        this.encKey = r100;
    }

    public void setHMAC(String r100) {
        this.HMAC = r100;
    }

    public void setPublicKey(String r100) {
        this.publicKey = r100;
    }

    public void setQ1Id(String r100) {
        this.q1Id = r100;
    }

    public void setResultCode(String r100) {
        this.resultCode = r100;
    }

    public void setResultMsg(String r100) {
        this.resultMsg = r100;
    }
}
